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
    exports br.lawtrel.pdv.Controller to javafx.graphics;
    exports br.lawtrel.pdv.Model to javafx.graphics;
    opens br.lawtrel.pdv.Model to javafx.fxml;
    exports br.lawtrel.pdv.View to javafx.graphics;
    opens br.lawtrel.pdv.View to javafx.fxml;
    exports br.lawtrel.pdv.Model.dao to javafx.graphics;
    opens br.lawtrel.pdv.Model.dao to javafx.fxml;
}

