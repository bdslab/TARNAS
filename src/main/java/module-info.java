module tarnas {
    // required modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.antlr.antlr4.runtime;
    requires java.desktop;
    requires jdk.jsobject;
    requires info.picocli;
    requires java.logging;
    requires org.jsoup;

    // all types in it.unicam.cs.bdslab.tarnas.model.* packages are accessible via reflection in the javafx.fxml module
    opens it.unicam.cs.bdslab.tarnas.model.rnastructure to javafx.base;
    opens it.unicam.cs.bdslab.tarnas.model.rnafile to javafx.base;
    opens it.unicam.cs.bdslab.tarnas.model.utils to javafx.base;
    // all types in it.unicam.cs.bdslab.tarnas.view.* package are accessible via reflection in the javafx.fxml module
    opens it.unicam.cs.bdslab.tarnas.view.utils to javafx.fxml;
    opens it.unicam.cs.bdslab.tarnas.view to javafx.fxml, info.picocli;
    // javafx.graphics needs to access the it.unicam.cs.bdslab.tarnas exported package
    exports it.unicam.cs.bdslab.tarnas to javafx.graphics;
    opens it.unicam.cs.bdslab.tarnas.view.cli to info.picocli, javafx.fxml;

}
