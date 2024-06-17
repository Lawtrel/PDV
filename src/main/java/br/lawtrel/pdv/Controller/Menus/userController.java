package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.User;
import br.lawtrel.pdv.Model.Venda;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import br.lawtrel.pdv.Model.dao.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class userController extends Janelas {

    @FXML
    public MenuItem menufuncionarios;
    @FXML
    public MenuItem menuprodutos;
    @FXML
    public MenuItem menuvendas;
    @FXML
    private TableView<User> userTable;
    @FXML
    public TableColumn<Produto, String> codigocolumn;
    @FXML
    public TableColumn<Produto, Integer> tipocolumn;
    @FXML
    public TableColumn<Produto, String> nomecolumn;
    @FXML
    public TableColumn<Venda,Double> totaldevendascolumn;
    @FXML
    private final ObservableList<User> userList;

    public userController() throws SQLException {
        Connection connection = connectDB.getConnection();

        userList = FXCollections.observableArrayList();

    }
    public void initialize() {
        codigocolumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomecolumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tipocolumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        userTable.setItems(userList);

    }
}
