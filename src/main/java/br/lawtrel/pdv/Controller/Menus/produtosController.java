package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class produtosController extends Janelas {

    @FXML
    private final ObservableList<Produto> produtosList;
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
    private TableColumn<Produto, String> precocolumn;
    @FXML
    private TableColumn<Produto, Integer> quantidadecolumn;
    @FXML
    private TextField searchBar;

    public produtosController() throws SQLException {
        Connection connection = connectDB.getConnection();
        ProdutoDao produtoDao = new ProdutoDao(connection);
        produtosList = FXCollections.observableArrayList();
        loadProdutos(produtoDao);

    }

    public void initialize() {
        codigocolumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        descricaocolumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        quantidadecolumn.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        precocolumn.setCellValueFactory(new PropertyValueFactory<>("preco"));

        FilteredList<Produto> filteredList = new FilteredList<>(produtosList, p -> true);
        productsTable.setItems(filteredList);
        //Metodo para buscar produto no banco de dados
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> filteredList.setPredicate(produto -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowercaseFilter = newValue.toLowerCase();
            if (String.valueOf(produto.getCodigo()).contains(lowercaseFilter)) {
                return true;
            } else return produto.getDescricao().toLowerCase().contains(lowercaseFilter);
        }));

    }

    private void loadProdutos(ProdutoDao produtoDao) {
        produtosList.addAll(produtoDao.listarTodos());
    }


}
