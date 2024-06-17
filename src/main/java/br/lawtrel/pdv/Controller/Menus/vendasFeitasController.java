package br.lawtrel.pdv.Controller.Menus;

import br.lawtrel.pdv.Model.Venda;
import br.lawtrel.pdv.Model.connectDB;
import br.lawtrel.pdv.Model.dao.VendaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class vendasFeitasController extends Janelas {

    @FXML
    private final ObservableList<Venda> vendasList;
    @FXML
    public MenuItem menufuncionarios;
    @FXML
    public MenuItem menuprodutos;
    @FXML
    public MenuItem menuvendas;
    @FXML
    public TableColumn<Venda, String> datacolumn;
    @FXML
    public TableColumn<Venda, Double> valorcolumn;
    @FXML
    public TableColumn<Venda, Boolean> pagocolumn;
    @FXML
    public TableColumn<Venda, String> codigocolumn;
    @FXML
    public TableColumn<Venda, String> pagamentocolumn;
    @FXML
    private TableView<Venda> vendasTable;
    @FXML
    private Label totalVendasLabel;

    public vendasFeitasController() throws SQLException {
        Connection connection = connectDB.getConnection();
        VendaDao vendaDao = new VendaDao(connection);
        vendasList = FXCollections.observableArrayList();
        loadVendas(vendaDao);

    }

    @FXML
    public void initialize() {
        codigocolumn.setCellValueFactory(new PropertyValueFactory<>("codVenda"));
        datacolumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        valorcolumn.setCellValueFactory(new PropertyValueFactory<>("valor"));
        pagocolumn.setCellValueFactory(new PropertyValueFactory<>("pago"));
        pagamentocolumn.setCellValueFactory(new PropertyValueFactory<>("formaDePagamento"));
        vendasTable.setItems(vendasList);
        try {
            Connection connection = connectDB.getConnection();
            VendaDao vendaDao = new VendaDao(connection);
            totalVendas(vendaDao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadVendas(VendaDao vendaDao) {
        vendasList.addAll(vendaDao.listar());
    }

    private void totalVendas(VendaDao vendaDao) {
        double totalvendas = vendaDao.calcularTotalVendas();
        totalVendasLabel.setText(String.format("Total Vendido: R$ %.2f", totalvendas));
    }
}
