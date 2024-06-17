package br.lawtrel.pdv.Controller;

import br.lawtrel.pdv.Model.User;
import br.lawtrel.pdv.Model.dao.UserDao;
import br.lawtrel.pdv.Model.dao.UserDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
public class loginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private final UserDao userDao = new UserDaoImp();

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username,password);
        userDao.getUser(username,password);



            System.out.println("Login feito com sucesso!");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/vendasScreen.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);;
            stage.setTitle("Tela de Vendas");
            stage.show();

            System.out.println("Senha Invalida!");



    }

    @FXML
    private void btnLoginADM(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username,password);
        userDao.getUser(username,password);

        if ("admin".equals(username) && "admin".equals(password)) {
            System.out.println("Login feito com sucesso!");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/produtosScreen.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);;
            stage.setTitle("Tela de Vendas");
            stage.show();

        } else {
            System.out.println("Senha Invalida!");
        }
    }



    public void btnRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username,password);
        userDao.addUser(user);
        System.out.println("User cadastrado!");
    }
}