package br.lawtrel.pdv.Controller;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.Venda;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import br.lawtrel.pdv.Model.dao.VendaDao;
import br.lawtrel.pdv.Model.connectDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
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
        int codigo = Integer.parseInt(productCodeField.getText());
        int quantidade = Integer.parseInt(quantityField.getText());

        Produto produto = new Produto();
        produto.setCodProduto(String.valueOf(codigo));
        produto.setName("coco");
        produto.setQuantity(quantidade);
        produto.setPrice(10.0 * quantidade);

        produtosList.add(produto);
        produtoDao.insert(produto);

        atualizarTotal();

    }

    @FXML
    private void btnFinishSale() {
        Venda venda = new Venda();
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
        return produtosList.stream().mapToDouble(Produto::getPrice).sum();

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
