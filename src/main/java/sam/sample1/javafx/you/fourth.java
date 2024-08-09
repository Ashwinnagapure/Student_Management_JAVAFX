package sam.sample1.javafx.you;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

public class fourth extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TextArea ta = new TextArea();// Text Area class for assigning a text area for writing
        ta.setPrefColumnCount(100);// number of words in a column
        ta.setPrefRowCount(20);// number of words in a row

        Slider sa = new Slider(10, 50, 10); // slider class with it assigning min , max and present value

        /* Writing Lambda Expression for Handling the event of Sliding and increasing
        and decreasing the size of the font for that using value property and adding listener for changing font
         in the text area according to the silder value */
        sa.valueProperty().addListener(e -> {
            ta.setFont(Font.font(sa.getValue()));
        });

        VBox v = new VBox();
        v.getChildren().addAll(ta, sa); // vertical layout box for arranging the component in vertical order


        Scene s = new Scene(v, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
