package br.lawtrel.pdv.Controller;

import br.lawtrel.pdv.Model.User;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.dao.UserDao;
import br.lawtrel.pdv.dao.UserDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private UserDao userDao = new UserDaoImp();

    @FXML
    private void btnLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username,password);
        userDao.getUser(username,password);
        if (user != null || ("admin".equals(username) && "admin".equals(password))) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
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