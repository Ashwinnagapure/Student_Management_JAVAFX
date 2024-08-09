package sam.sample1.javafx.you;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

import java.io.FileInputStream;
import java.util.Scanner;

public class five extends Application {

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

         /* Gives the calendar for picking up the date */
        DatePicker dd = new DatePicker();
        /* It handle the event for picking and displaying the date in the textarea*/
        dd.setOnAction(e->{
            ta.setText("Date : "+dd.getValue()+"\n"+ta.getText());
        });

        /* For picking up the different color */
        ColorPicker cc = new ColorPicker();
        /* it handle the event of giving the color to the text in text area*/
        cc.setOnAction(e->{
            ta.setStyle("-fx-text-fill:#"+cc.getValue().toString().substring(2,8));
        });

        /* Taking an button for opening the file*/
        Button b = new Button("Open File");
        /* Handling the event for opening the file from the perticular location in the file*/
        b.setOnAction(e->{
            FileChooser fp = new FileChooser();//chooses the file
            java.io.File file = fp.showOpenDialog(stage);// open the file choose box
            try  (Scanner sc = new Scanner(new FileInputStream(file))){
                /* In try catch handling Exception for file handing and taking a null string for storing the file content int
                that string and then displaying the file content in the text area*/
             String str=" " ;
             while(sc.hasNext())
             {
                 str=str+sc.nextLine()+"\n";
                 ta.setText(str);
             }
            }catch(Exception ee){}
        });

        VBox v = new VBox();
        v.setAlignment(Pos.TOP_CENTER);
        v.getChildren().addAll(ta, sa,dd,cc,b); // vertical layout box for arranging the component in vertical order


        Scene s = new Scene(v, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
