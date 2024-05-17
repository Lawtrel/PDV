package br.lawtrel.pdv.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class vendasController {
    @FXML
    private TextField productCodeField;

    @FXML
    private TextField quantityField;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private TableColumn<Product, String> codeColumn;

    @FXML
    private TableColumn<Product, String> descriptionColumn;

    @FXML
    private TableColumn<Product, Integer> quantityColumn;

    @FXML
    private TableColumn<Product, Double> priceTotalColumn;

    @FXML
    private Label totalLabel;

    @FXML
    private void handleAddProduct() {
        // Adicione o código para adicionar o produto à tabela
    }

    // Handler para finalizar venda
    @FXML
    private void handleFinishSale() {
        // Adicione o código para finalizar a venda
    }

    // Handler para cancelar venda
    @FXML
    private void handleCancelSale() {
        // Adicione o código para cancelar a venda
    }

    // Inicialize a tabela e outras configurações
    @FXML
    public void initialize() {
        // Configuração inicial da tabela
    }
}
