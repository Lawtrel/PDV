package br.lawtrel.pdv.Controller;

import br.lawtrel.pdv.Model.*;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import br.lawtrel.pdv.Model.dao.VendaDao;

import br.lawtrel.pdv.Model.MercadoPagoConfig;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class vendasController {
    @FXML
    private TextField productCodeField;

    @FXML
    private TextField quantityField;

    @FXML
    private TableView<Produto> productsTable;

    @FXML
    private TableColumn<Produto, String> codeColumn;

    @FXML
    private TableColumn<Produto, String> descriptionColumn;

    @FXML
    private TableColumn<Produto, Integer> quantityColumn;

    @FXML
    private TableColumn<Produto, Double> priceTotalColumn;

    @FXML
    private Label totalLabel;


    @FXML
    private final ObservableList<Produto> produtosList;

    private final VendaDao vendaDao;
    private final ProdutoDao produtoDao;

    public vendasController() throws SQLException {
        Connection connection = connectDB.getConnection();
        vendaDao = new VendaDao(connection);
        produtoDao = new ProdutoDao(connection);
        produtosList = FXCollections.observableArrayList();
        MercadoPagoConfig.initialize();

    }

    //private final Product productDao = new ProductDao();
    @FXML
    private void btnAddProduct() {
        String codigo = productCodeField.getText();
        int quantidade = Integer.parseInt(quantityField.getText());


        Produto produto = produtoDao.buscar(codigo);
        if (produto != null) {
            produto.setQuantidade(quantidade);
            produto.setPreco(produto.getPreco() * quantidade);
            produtosList.add(produto);
            //produtoDao.insert(produto);
            atualizarTotal();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("PRODUTO NÃO ENCONTRADO!");
            alert.setContentText("O PRODUTO COM O CÓDIGO " + codigo + "NÃO FOI ENCONTRADO NO BANCO DE DADOS!");
            alert.showAndWait();
        }

    }

    public void btnAddProductTEST() {
        String codigo = productCodeField.getText();
        int quantidade = Integer.parseInt(quantityField.getText());
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Item Teste");
        produto.setQuantidade(quantidade);
        produto.setPreco(2 * quantidade);
        produtosList.add(produto);
        produtoDao.insert(produto);
        atualizarTotal();
    }


    @FXML
    private void btnFinishSale() {
        Venda venda = new Venda();
        venda.setData(LocalDate.now());
        venda.setValor(calcularTotal());
        String formaDePagamento = selecionarFormaDePagamento();
        venda.setFormaDePagamento(formaDePagamento);

        switch (formaDePagamento) {
            case "Dinheiro" -> {
                double valorPago = solicitarValorPago();
                emitirNota(venda, valorPago);
                venda.setPago(true);
            }
            case "Cartão de Crédito", "Cartão de Débito" -> {
                String detalhesCartao = solicitarDetalhesCartao();
                processarPagamentoCartao(venda, detalhesCartao);
            }
            case "PIX" -> {
                emitirNota(venda, venda.getValor());
                venda.setPago(false);
            }
            case null, default -> emitirNota(venda, venda.getValor());
        }
        vendaDao.insert(venda);
        produtosList.clear();
        atualizarTotal();
    }
    public String selecionarFormaDePagamento() {
        List<String> choices = new ArrayList<>();
        choices.add("Dinheiro");
        choices.add("Cartão de Crédito");
        choices.add("Cartão de Débito");
        choices.add("PIX");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Dinheiro", choices);
        dialog.setTitle("Forma de Pagamento");
        dialog.setHeaderText("Escolha a forma de Pagamento");
        dialog.setContentText("Forma de Pagamento");
        Optional<String> result = dialog.showAndWait();
        return result.orElse("Dinheiro");
    }

    private double solicitarValorPago() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Valor Pago");
        dialog.setHeaderText("Pagamento em Dinheiro");
        dialog.setContentText("Insira o valor pago pelo cliente:");
        Optional<String> result = dialog.showAndWait();
        return result.map(Double::parseDouble).orElse(0.0);
    }

    private String solicitarDetalhesCartao() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Detalhes do Cartão");
        dialog.setHeaderText("Pagamento com Cartão");
        dialog.setContentText("Insira os detalhes do cartão:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse("");

    }

    private void processarPagamentoCartao(Venda venda, String detalhesCartao) {
        try {
            System.out.println("Detalhes do Cartão: " + detalhesCartao);

            Payment payment = new Payment()
                    .setTransactionAmount((float) venda.getValor())
                    .setToken(detalhesCartao)
                    .setDescription("Compra de produtos")
                    .setInstallments(1)
                    .setPaymentMethodId("visa")
                    .setPayer(new Payer().setEmail("capcomx10@gmail.com"));

            System.out.println("Processando pagamento...");

            payment.save();

            System.out.println("Status do pagamento: " + payment.getStatus());

            if (payment.getStatus() == Payment.Status.approved) {
                venda.setPago(true);
                emitirNota(venda, venda.getValor(), detalhesCartao);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Pagamento não aprovado");
                alert.setHeaderText("O pagamento com o cartão não foi aprovado.");
                alert.setContentText("Por favor, tente novamente.");
                alert.showAndWait();
                venda.setPago(false);
            }
        } catch (MPException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Pagamento");
            alert.setHeaderText("Ocorreu um erro ao processar o pagamento com o cartão.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            venda.setPago(false);
        }
    }


    private void emitirNota(Venda venda, double valorPago) {
        double troco = valorPago - venda.getValor();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nota Fiscal");
        alert.setHeaderText("Detalhes da Venda");
        alert.setContentText(String.format("Total: R$ %.2f\nValor Pago: R$ %.2f\nTroco: R$ %.2f\nForma de Pagamento: %s", venda.getValor(), valorPago, troco, venda.getFormaDePagamento()));
        alert.showAndWait();
    }

    private void emitirNota(Venda venda, double valorPago, String detalhesCartao) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nota Fiscal");
        alert.setHeaderText("Detalhes da Venda");
        alert.setContentText(String.format("Total: R$ %.2f\nValor Pago: R$ %.2f\nDetalhes do Cartão: %s\nForma de Pagamento: %s",
                venda.getValor(), valorPago, detalhesCartao, venda.getFormaDePagamento()));
        alert.showAndWait();
    }



    // Handler para cancelar venda
    @FXML
    private void btnCancelSale() {
        produtosList.clear();
        atualizarTotal();
    }

    private void atualizarTotal() {
        double total = calcularTotal();
        totalLabel.setText(String.format("Total: R$ %.2f",total));
    }

    private double calcularTotal() {
        return produtosList.stream().mapToDouble(Produto::getPreco).sum();

    }

    @FXML
    public void initialize() {
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        priceTotalColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));
        productsTable.setItems(produtosList);
    }

}
