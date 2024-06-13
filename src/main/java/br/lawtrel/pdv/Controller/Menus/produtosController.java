package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;

public class produtosController {
    @FXML
    private Menu menufuncionarios;
    @FXML
    private Menu menuprodutos;
    @FXML
    private Menu menuvendas;

    @FXML
    private TableColumn<Produto, Integer> idcolumn;
    @FXML
    private TableColumn<Produto, String> descricaocolumn;
    @FXML
    private TableColumn<Produto, String>  nomecolumn;
    @FXML
    private TableColumn<Produto, Integer>  quantidadecolumn;


    @FXML
    protected void swapprodutos(ActionEvent e){

    }
    @FXML
    protected void swapfuncionarios(ActionEvent e){

    }
    @FXML
    protected void swapvendas(ActionEvent e){

    }
}
