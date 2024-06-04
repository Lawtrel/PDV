package br.lawtrel.pdv.Controller;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.Venda;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import br.lawtrel.pdv.Model.dao.VendaDao;
import br.lawtrel.pdv.Model.connectDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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

    private final ObservableList<Produto> produtosList;

    private final Connection connection;
    private final VendaDao vendaDao;
    private final ProdutoDao produtoDao;

    public vendasController() throws SQLException {
        connection = connectDB.getConnection();
        vendaDao = new VendaDao(connection);
        produtoDao = new ProdutoDao(connection);
        produtosList = FXCollections.observableArrayList();

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
            produtoDao.insert(produto);
            atualizarTotal();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("PRODUTO NÃO ENCONTRADO!");
            alert.setContentText("O PRODUTO COM O CÓDIGO " + codigo + "NÃO FOI ENCONTRADO NO BANCO DE DADOS!");
            alert.showAndWait();
        }

       /* Produto produto = new Produto(); //   ANTIGO METODO
        produto.setCodigo(codigo);
        produto.setDescricao("coco");
        produto.setQuantidade(quantidade);
        produto.setPreco(2 * quantidade);
        */

    }

    public void btnAddProductTEST(ActionEvent actionEvent) {
        String codigo = productCodeField.getText();
        int quantidade = Integer.parseInt(quantityField.getText());
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Item Teste");
        produto.setQuantidade(quantidade);
        produto.setPreco(produto.getPreco() * quantidade);
        produtosList.add(produto);
        produtoDao.insert(produto);
    }


    @FXML
    private void btnFinishSale() {
        Venda venda = new Venda();
        venda.setData(LocalDate.now());
        venda.setValor(calcularTotal());

        vendaDao.insert(venda);
        produtosList.clear();
        atualizarTotal();
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
