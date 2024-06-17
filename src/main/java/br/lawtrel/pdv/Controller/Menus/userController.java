package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.User;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.UserDao;
import br.lawtrel.pdv.Model.dao.UserDaoImp;
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
    private final ObservableList<User> userList;
    @FXML
    public MenuItem menufuncionarios;
    @FXML
    public MenuItem menuprodutos;
    @FXML
    public MenuItem menuvendas;
    @FXML
    public TableColumn<Produto, String> codigocolumn;
    @FXML
    public TableColumn<Produto, String> nomecolumn;
    @FXML
    private TableView<User> userTable;

    public userController() throws SQLException {
        Connection connection = connectDB.getConnection();
        UserDao userDao = new UserDaoImp(connection);
        userList = FXCollections.observableArrayList();
        loadUsers(userDao);

    }

    public void initialize() {
        codigocolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomecolumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        userTable.setItems(userList);

    }

    private void loadUsers(UserDao userDao) {
        userList.addAll(userDao.getAllUsers());
    }
}
