package sam.sample1.javafx.you;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*Implementing Interfaces*/
public class second extends Application /*implements EventHandler<ActionEvent>*/ {
    Button b;
    int count = 0;

    @Override
    public void start(Stage stage) throws Exception {
        b = new Button("ok");
        b.setPrefSize(100, 50);

        /* using Lambda Expression */
        b.setOnAction(e->{
            count++;
            b.setText(" "+count);
        });

        FlowPane fp = new FlowPane(b);


        Scene s = new Scene(fp, 400, 400);

        stage.setScene(s);
        stage.show();
    }

  /*  @Override
    public void handle(ActionEvent a) {
        count++;
        b.setText(" " + count);
    }*/

    public static void main(String[] args) {
        launch(args);
    }


}
