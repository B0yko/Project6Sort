module com.example.project6sort {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project6sort to javafx.fxml;
    exports com.example.project6sort;
}