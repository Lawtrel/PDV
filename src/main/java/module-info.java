/*module br.lawtrel.pdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.lawtrel.pdv to javafx.fxml;
    exports br.lawtrel.pdv to javafx.graphics;
}

 */

/*module br.lawtrel.pdv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens br.lawtrel.pdv.Controller to javafx.fxml;
    exports br.lawtrel.pdv to javafx.graphics;
    exports br.lawtrel.pdv.Controller to javafx.graphics;
    exports br.lawtrel.pdv.Model to javafx.graphics;
    opens br.lawtrel.pdv.Model to javafx.base;
    exports br.lawtrel.pdv.View to javafx.graphics;
    opens br.lawtrel.pdv.View to javafx.fxml;
    exports br.lawtrel.pdv.Model.dao to javafx.graphics;
    opens br.lawtrel.pdv.Model.dao to javafx.fxml;
}*/

    module  br.lawtrel.pdv {
        requires java.logging;
        requires java.sql;
        requires javafx.base;
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.graphics;
        requires junit;
        requires dx.java;

        opens br.lawtrel.pdv.Model to javafx.base;
        opens br.lawtrel.pdv to javafx.fxml;
        exports br.lawtrel.pdv;
        exports  br.lawtrel.pdv.Model;

        opens br.lawtrel.pdv.Controller to javafx.fxml;
        exports  br.lawtrel.pdv.Controller;

        opens  br.lawtrel.pdv.View to javafx.graphics;
        exports  br.lawtrel.pdv.View;
    }

