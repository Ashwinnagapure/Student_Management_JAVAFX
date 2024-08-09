module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
            
                            
    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    exports sam.sample.javafx.exam; // Export the package containing the class
    exports sam.sample1.javafx.you;
    exports  pro.project.javafx.one;

}
