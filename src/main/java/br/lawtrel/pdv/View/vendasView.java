package br.lawtrel.pdv.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class vendasView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/vendasScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tela de Vendas");
        stage.show();
        Application.setUserAgentStylesheet(getClass().getResource("/br/lawtrel/pdv/assets/themes/dracula.css").toExternalForm());
    }
}