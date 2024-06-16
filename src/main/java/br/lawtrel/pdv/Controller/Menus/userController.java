package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.Venda;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;

public class userController extends Janelas {


    public MenuItem menufuncionarios;
    public MenuItem menuprodutos;
    public MenuItem menuvendas;
    public TableColumn<Produto, String> codigocolumn;
    public TableColumn<Produto, Integer> tipocolumn;
    public TableColumn<Produto, String> nomecolumn;
    public TableColumn<Venda,Double> totaldevendascolumn;
}
