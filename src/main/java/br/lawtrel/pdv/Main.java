package br.lawtrel.pdv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/br/lawtrel/pdv/assets/logo.jpg"))));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/loginScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();
        Application.setUserAgentStylesheet(Objects.requireNonNull(getClass().getResource("/br/lawtrel/pdv/assets/themes/dracula.css")).toExternalForm());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
