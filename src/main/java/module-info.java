module it.unicam.cs.bdslab.tarnas {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.antlr.antlr4.runtime;
    requires java.logging;

    opens it.unicam.cs.bdslab.tarnas.model.rnastructure to javafx.base;
    exports it.unicam.cs.bdslab.tarnas.model.rnastructure;

    opens it.unicam.cs.bdslab.tarnas.model.rnafile to javafx.base;
    exports it.unicam.cs.bdslab.tarnas.model.rnafile;

    opens it.unicam.cs.bdslab.tarnas.model.utils to javafx.base;
    exports it.unicam.cs.bdslab.tarnas.model.utils;

    opens it.unicam.cs.bdslab.tarnas to javafx.fxml;
    exports it.unicam.cs.bdslab.tarnas to javafx.graphics;

    exports it.unicam.cs.bdslab.tarnas.view.utils;
    opens it.unicam.cs.bdslab.tarnas.view.utils to javafx.fxml;

    exports it.unicam.cs.bdslab.tarnas.view;
    opens it.unicam.cs.bdslab.tarnas.view to javafx.fxml;
}
