package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.Venda;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;

public class vendasFeitasController extends Janelas{

    @FXML
    public MenuItem menufuncionarios;
    @FXML
    public MenuItem menuprodutos;
    @FXML
    public MenuItem menuvendas;
    @FXML
    public TableColumn<Venda, String> nomecolumn;
    @FXML
    public TableColumn<Venda, Integer> quantidadecolumn;
    @FXML
    public TableColumn<Venda, Double> valorcolumn;
    public TableColumn<Venda, String> codigocolumn;
}
