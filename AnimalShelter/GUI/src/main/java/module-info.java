module org.fhict {
    requires javafx.controls;
    requires javafx.fxml;
    requires Logic;

    opens org.fhict.gui to javafx.fxml;
    exports org.fhict.gui;
}
