module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tf.teamflowcode to javafx.fxml;
    exports com.tf.teamflowcode;
}
