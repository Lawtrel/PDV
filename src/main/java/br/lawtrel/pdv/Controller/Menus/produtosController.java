package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import br.lawtrel.pdv.View.produtosView;
import br.lawtrel.pdv.View.userView;
import br.lawtrel.pdv.View.vendasFeitasView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;

import java.sql.Connection;
import java.sql.SQLException;

public class produtosController {
    @FXML
    private Menu menufuncionarios;
    @FXML
    private Menu menuprodutos;
    @FXML
    private Menu menuvendas;

    @FXML
    private TableColumn<Produto, Integer> codigocolumn;
    @FXML
    private TableColumn<Produto, String> descricaocolumn;
    @FXML
    private TableColumn<Produto, String>  precocolumn;
    @FXML
    private TableColumn<Produto, Integer>  quantidadecolumn;

    private final ObservableList<Produto> produtosList;

    private final Connection connection;
    private final ProdutoDao produtoDao;
    public produtosController() throws SQLException {
        connection = connectDB.getConnection();
        produtoDao = new ProdutoDao(connection);
        produtosList = FXCollections.observableArrayList();

    }

    public produtosController(ObservableList<Produto> produtosList, Connection connection, ProdutoDao produtoDao) {
        this.produtosList = produtosList;
        this.connection = connection;
        this.produtoDao = produtoDao;
    }

    @FXML
    protected void swapprodutos(ActionEvent e){

    }
    @FXML
    protected void swapfuncionarios(ActionEvent e){

    }
    @FXML
    protected void swapvendas(ActionEvent e){

    }
}
