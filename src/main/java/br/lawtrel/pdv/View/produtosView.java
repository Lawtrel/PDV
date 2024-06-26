package br.lawtrel.pdv.View;

import atlantafx.base.theme.Dracula;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class produtosView extends Application implements Initializable {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/produtosScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("/br/lawtrel/pdv/assets/logo.png")).toExternalForm()));
        stage.setWidth(655);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.setTitle("Tela Produtos");
        stage.show();

        Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
