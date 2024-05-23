package br.lawtrel.pdv.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class loginView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/loginScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(getClass().getResource("/br/lawtrel/pdv/assets/logo.png").toExternalForm()));
        stage.setWidth(355);
        stage.setHeight(190);
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();

        Application.setUserAgentStylesheet(getClass().getResource("/br/lawtrel/pdv/assets/themes/dracula.css").toExternalForm());

        //Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
    }
}
