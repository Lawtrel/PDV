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
        FXMLLoader produtosCont = new FXMLLoader(getClass().getResource("produtosController.fxml"));
        FXMLLoader vendasCont = new FXMLLoader(getClass().getResource("vendasFeitasController.fxml"));
        FXMLLoader funcionariosCont = new FXMLLoader(getClass().getResource("funcionariosController.fxml"));

        primaryStage = stage;
        primaryStage.setTitle("Muda janela");

        Parent parentprodutos = produtosCont.load();
        Parent parentvendas = vendasCont.load();
        Parent parentfuncionarios = funcionariosCont.load();


        stage.show();
    }
}
