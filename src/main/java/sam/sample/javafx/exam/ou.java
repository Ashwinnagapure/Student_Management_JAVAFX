package sam.sample.javafx.exam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class ou extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button b = new Button("Click me ");
        b.setTextFill(Color.BLACK);
        FlowPane fp = new FlowPane(b);

        Scene sc = new Scene(fp,400,400);

        stage.setScene(sc);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
