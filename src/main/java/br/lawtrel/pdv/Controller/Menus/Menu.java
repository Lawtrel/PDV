package br.lawtrel.pdv.Controller.Menus;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Menu extends Application implements Initializable {

    public static Scene sceneprodutos;
    public static Scene scenevendas;
    public static Scene scenefuncionarios;

    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        FXMLLoader produtosCont = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/produtosScreen.fxml"));
        FXMLLoader vendasCont = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/vendasFeitas.fxml"));
        FXMLLoader funcionariosCont = new FXMLLoader(getClass().getResource("/br/lawtrel/pdv/userScreen.fxml"));



        primaryStage.setTitle("Troca de telas");

        Parent parentProdutosS = produtosCont.load();
        Parent parentUserS = funcionariosCont.load();
        Parent parentVendasFeitas = vendasCont.load();


        sceneprodutos = new Scene(parentProdutosS, 600, 450);
        scenefuncionarios = new Scene(parentUserS, 600, 450);
        scenevendas = new Scene(parentVendasFeitas, 600, 450);


        stage.setScene(scenefuncionarios);
        stage.show();
    }

    public static void trocaTela(int op){
        switch (op){
            case 1:
                primaryStage.setScene(sceneprodutos);
                break;

            case 2:
                primaryStage.setScene(scenefuncionarios);
                break;

            case 3:
                primaryStage.setScene(scenevendas);
                break;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
