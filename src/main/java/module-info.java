module it.unicam.cs.bdslab.TARNAS {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.unicam.cs.bdslab.TARNAS to javafx.fxml;
    exports it.unicam.cs.bdslab.TARNAS;
}
