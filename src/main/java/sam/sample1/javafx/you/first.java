package sam.sample1.javafx.you;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class first extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Button b = new Button("Click Me");
        b.setTextFill(Color.ALICEBLUE);
//        b.setStyle("-fx-border-color:yellow;-fx-background-color:navy;");
        b.setMnemonicParsing(true);
        Tooltip tp = new Tooltip(" Hey Can You Click Me  ");
       b.setTooltip(tp);

        Alert a = new Alert(Alert.AlertType.INFORMATION,"you touch me");
        b.setOnAction(actionEvent -> a.show());


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
