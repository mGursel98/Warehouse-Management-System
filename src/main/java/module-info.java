module Controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires log4j.api;
    requires mysql.connector.java;

    opens Controllers to javafx.fxml;
    exports Controllers;
}