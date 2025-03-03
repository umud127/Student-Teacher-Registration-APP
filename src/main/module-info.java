module az.The_Best {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires java.sql;

    opens az.The_Best to javafx.fxml;
    exports az.The_Best;
}