package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.Venda;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.ProdutoDao;
import br.lawtrel.pdv.Model.dao.VendaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class vendasFeitasController extends Janelas{

    @FXML
    public MenuItem menufuncionarios;
    @FXML
    public MenuItem menuprodutos;
    @FXML
    public MenuItem menuvendas;
    @FXML
    private TableView<Venda> vendasTable;
    @FXML
    public TableColumn<Venda, String> nomecolumn;
    @FXML
    public TableColumn<Venda, Integer> quantidadecolumn;
    @FXML
    public TableColumn<Venda, Double> valorcolumn;
    @FXML
    public TableColumn<Venda, String> codigocolumn;
    @FXML
    private final ObservableList<Venda> vendasList;

    public vendasFeitasController() throws SQLException {
        Connection connection = connectDB.getConnection();
        VendaDao vendaDao = new VendaDao(connection);
        vendasList = FXCollections.observableArrayList();

    }
    @FXML
    public void initialize() {
        codigocolumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomecolumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        quantidadecolumn.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        valorcolumn.setCellValueFactory(new PropertyValueFactory<>("valor"));
        vendasTable.setItems(vendasList);

    }
}
