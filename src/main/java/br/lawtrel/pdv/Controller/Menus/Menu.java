package br.lawtrel.pdv.Controller.Menus;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Menu extends Application {

    private static Scene sceneprodutos,scenevendas,scenefuncionarios;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader produtosCont = new FXMLLoader(getClass().getResource("produtosScreen.fxml"));
        FXMLLoader vendasCont = new FXMLLoader(getClass().getResource("vendasFeitas.fxml"));
        FXMLLoader funcionariosCont = new FXMLLoader(getClass().getResource("userScreen.fxml"));

        primaryStage = stage;
        primaryStage.setTitle("Troca de telas");

        Parent parentProdutosS = produtosCont.load();
        Parent parentUserS = funcionariosCont.load();
        Parent parentVendasFeitas = vendasCont.load();

        sceneprodutos = new Scene(parentProdutosS, 400, 300);
        scenefuncionarios = new Scene(parentUserS, 400, 300);
        scenevendas = new Scene(parentVendasFeitas, 400, 300);

        stage.setScene(sceneprodutos);
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

}
