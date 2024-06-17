package br.lawtrel.pdv.View;

import atlantafx.base.theme.Dracula;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F2) {
                System.out.println("foi");
                mostrarProdutos();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Tela de Vendas");
        stage.show();
        Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());
    }

    private void mostrarProdutos() {
        try {
            Stage stage2 = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/produtosScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.setTitle("Nova Janela");

            stage2.setX(500);
            stage2.setY(200);

            stage2.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
