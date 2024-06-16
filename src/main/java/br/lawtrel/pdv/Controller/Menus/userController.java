package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.Venda;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;

public class userController extends Janelas {

    @FXML
    public MenuItem menufuncionarios;
    @FXML
    public MenuItem menuprodutos;
    @FXML
    public MenuItem menuvendas;
    @FXML
    public TableColumn<Produto, String> codigocolumn;
    @FXML
    public TableColumn<Produto, Integer> tipocolumn;
    @FXML
    public TableColumn<Produto, String> nomecolumn;
    @FXML
    public TableColumn<Venda,Double> totaldevendascolumn;
}
