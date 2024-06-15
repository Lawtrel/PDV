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
        primaryStage.setTitle("Muda janela");

        Parent parentprodutos = produtosCont.load();
        Parent parentvendas = vendasCont.load();
        Parent parentfuncionarios = funcionariosCont.load();


        stage.show();
    }
}
