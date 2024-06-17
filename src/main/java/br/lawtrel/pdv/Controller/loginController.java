package br.lawtrel.pdv.Controller;

import br.lawtrel.pdv.Controller.Menus.Menu;
import br.lawtrel.pdv.Model.User;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.UserDao;
import br.lawtrel.pdv.Model.dao.UserDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class loginController {
    private final UserDao userDao;
    @FXML
    public Button admButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public loginController() throws SQLException {
        Connection connection = connectDB.getConnection();
        this.userDao = new UserDaoImp(connection);
    }

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = userDao.getUser(username, password);
        if (user != null) {
            System.out.println("Login feito com sucesso!");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/vendasScreen.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tela de Vendas");
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("USUARIO NÃO ENCONTRADO!");
            alert.setContentText("O USUARIO " + username + "NÃO FOI ENCONTRADO NO BANCO DE DADOS!");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnLoginADM(ActionEvent event) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("admin".equals(username) && "admin".equals(password)) {
            System.out.println("Login feito com sucesso!");
            Stage stage = (Stage) admButton.getScene().getWindow();
            new Menu().start(stage);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("USUARIO NÃO ENCONTRADO!");
            alert.setContentText("O USUARIO " + username + "NÃO FOI ENCONTRADO NO BANCO DE DADOS!");
            alert.showAndWait();
        }
    }


    public void btnRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username, password);
        userDao.addUser(user);
        System.out.println("User cadastrado!");
    }
}