module br.lawtrel.pdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.lawtrel.pdv to javafx.fxml;
    exports br.lawtrel.pdv;
}