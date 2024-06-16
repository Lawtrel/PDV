package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class produtosController extends Janelas {

    @FXML
    public MenuItem menufuncionarios;
    @FXML
    public MenuItem menuprodutos;
    @FXML
    public MenuItem menuvendas;
    @FXML
    private TableView<Produto> productsTable;

    @FXML
    private TableColumn<Produto, Integer> codigocolumn;
    @FXML
    private TableColumn<Produto, String> descricaocolumn;
    @FXML
    private TableColumn<Produto, String>  precocolumn;
    @FXML
    private TableColumn<Produto, Integer>  quantidadecolumn;

    private final ObservableList<Produto> produtosList;

    public produtosController() throws SQLException {
        Connection connection = connectDB.getConnection();
        ProdutoDao produtoDao = new ProdutoDao(connection);
        produtosList = FXCollections.observableArrayList();

    }
    public void initialize() {
        codigocolumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        descricaocolumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        quantidadecolumn.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        precocolumn.setCellValueFactory(new PropertyValueFactory<>("preco"));
        productsTable.setItems(produtosList);

    }





}
