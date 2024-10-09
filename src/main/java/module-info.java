module com.svgs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires transitive javafx.graphics;

    opens com.svgs to javafx.fxml;
    exports com.svgs;
}
