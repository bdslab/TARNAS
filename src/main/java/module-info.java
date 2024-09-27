module tarnas {
    // required modules
    requires javafx.controls;
    requires javafx.fxml;
    requires org.antlr.antlr4.runtime;
    requires java.logging;
    requires java.xml;
    requires java.desktop;

    // all types in it.unicam.cs.bdslab.tarnas.model.* packages are accessible via reflection in the javafx.fxml module
    opens it.unicam.cs.bdslab.tarnas.model.rnastructure to javafx.base;
    opens it.unicam.cs.bdslab.tarnas.model.rnafile to javafx.base;
    opens it.unicam.cs.bdslab.tarnas.model.utils to javafx.base;
    // all types in it.unicam.cs.bdslab.tarnas.view.* package are accessible via reflection in the javafx.fxml module
    opens it.unicam.cs.bdslab.tarnas.view.utils to javafx.fxml;
    opens it.unicam.cs.bdslab.tarnas.view to javafx.fxml;
    // javafx.graphics needs to access the it.unicam.cs.bdslab.tarnas exported package
    exports it.unicam.cs.bdslab.tarnas to javafx.graphics;
}
