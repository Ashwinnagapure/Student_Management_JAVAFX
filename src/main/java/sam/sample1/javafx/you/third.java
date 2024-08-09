package sam.sample1.javafx.you;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class third extends Application implements EventHandler<ActionEvent> {
    Text t;
    RadioButton r1, r2, r3;
    CheckBox c1, c2, c3;
    ChoiceBox<Integer> ch;

    @Override
    public void start(Stage stage) throws Exception {
        t = new Text("Hello World");
        HBox h1 = new HBox();
        h1.getChildren().add(t);

        r1 = new RadioButton("Red");
        r2 = new RadioButton("Green");
        r3 = new RadioButton("Blue");
        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);

        HBox h2 = new HBox();
        h2.setSpacing(25);
        h2.setPadding(new Insets(20, 20, 20, 20));
        h2.getChildren().addAll(r1, r2, r3);


        c1 = new CheckBox("Normal");
        c2 = new CheckBox("Bold");
        c3 = new CheckBox("Italic");

        HBox h3 = new HBox();
        h3.setSpacing(25);
        h3.setPadding(new Insets(10, 10, 10, 10));
        h3.getChildren().addAll(c1, c2, c3);


        ch = new ChoiceBox<>();

        ch.setPadding(new Insets(20, 20,20,20));
        ch.getItems().addAll(10, 20, 30, 40, 50);

        r1.setOnAction(this);
        r2.setOnAction(this);
        r3.setOnAction(this);
        c1.setOnAction(this);
        c2.setOnAction(this);
        c3.setOnAction(this);
        ch.setOnAction(this);


        VBox v = new VBox();
        v.setSpacing(25);
        v.setPadding(new Insets(10, 10, 10, 10));
        v.getChildren().addAll(h1, h2, h3, ch);

        Scene s = new Scene(v, 500, 500);

        stage.setScene(s);
        stage.show();


    }

    @Override
    public void handle(ActionEvent a) {
        FontWeight fw = FontWeight.NORMAL;
        FontPosture fp = FontPosture.REGULAR;

        if (r1.isSelected())
            t.setFill(Paint.valueOf("RED"));
        if (r2.isSelected())
            t.setFill(Paint.valueOf("GREEN"));
        if (r3.isSelected())
            t.setFill(Paint.valueOf("BLUE"));

        if (c2.isSelected())
            fw = FontWeight.BOLD;
        if (c3.isSelected())
            fp = FontPosture.ITALIC;

        t.setFont(Font.font("Times new roman", fw, fp, ch.getValue()));


    }

    public static void main(String[] args) {
        launch(args);
    }
}
