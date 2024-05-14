/*module br.lawtrel.pdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.lawtrel.pdv to javafx.fxml;
    exports br.lawtrel.pdv to javafx.graphics;
}

 */

module br.lawtrel.pdv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens br.lawtrel.pdv.Controller to javafx.fxml;
    exports br.lawtrel.pdv to javafx.graphics;
}

