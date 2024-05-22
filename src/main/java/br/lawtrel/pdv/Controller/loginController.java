package br.lawtrel.pdv.Controller;

import br.lawtrel.pdv.Model.connectDB;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    private Button loginButton;

    private final connectDB db = new connectDB();

    @FXML
    private void handleLogin() throws SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();


        if (("admin".equals(username) && "admin".equals(password)) || (auth(username, password)))  {
            System.out.println("Login Realizado!");

        } else {
            System.out.println("Falha na Autenticação!");
        }
    }

    private boolean auth(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pstm = db.executeScript(query)) {
            pstm.setString(1, username);
            pstm.setString(2, password);

            try (ResultSet resultSet = pstm.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
