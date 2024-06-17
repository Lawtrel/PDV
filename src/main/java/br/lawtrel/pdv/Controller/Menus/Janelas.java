package br.lawtrel.pdv.Controller.Menus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class Janelas {
    @FXML
    protected void swapprodutos(ActionEvent e) {
        Menu.trocaTela(1);
    }

    @FXML
    protected void swapfuncionarios(ActionEvent e) {
        Menu.trocaTela(2);
    }

    @FXML
    protected void swapvendas(ActionEvent e) {
        Menu.trocaTela(3);
    }
}
