package br.lawtrel.pdv.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class produtosView extends Application{
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
        stage.setTitle("Tela PRodutos");
        stage.show();

        Application.setUserAgentStylesheet(Objects.requireNonNull(getClass().getResource("/br/lawtrel/pdv/assets/themes/dracula.css")).toExternalForm());
    }
}
