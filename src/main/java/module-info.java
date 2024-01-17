module com.test.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires mysql.connector.j;

    opens com.test.demo to javafx.fxml;
    exports com.test.demo;
}