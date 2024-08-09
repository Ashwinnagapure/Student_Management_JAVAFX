package sam.sample1.javafx.you;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;


class customer {
    public int costomer_Id;
    public String name;
    public String address;

    customer(int costomer_Id, String name, String address) {
        this.costomer_Id = costomer_Id;
        this.name = name;
        this.address = address;
    }

    public int getCostomer_Id() {
        return costomer_Id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


public class six extends Application {

    int count = 0;

    @Override
    public void start(Stage stage) throws Exception {

        HashMap<Integer, customer> hm = new HashMap<>();

        Font f = new Font("Times New Roman", 20);
        Label l1 = new Label("Customer ID");
        l1.setFont(f);
        Label l2 = new Label("Name");
        l1.setFont(f);
        Label l3 = new Label("Address");
        l1.setFont(f);

        ComboBox<Integer> cb = new ComboBox<>();
        TextField t1 = new TextField();
        t1.setPrefColumnCount(15);

        TextField t2 = new TextField();
        t2.setPrefColumnCount(20);

        Button save = new Button("Save");
        Button create = new Button("create");

        create.setOnAction(e -> {
            ++count;
            cb.getItems().add(count);
            cb.setValue(count);
            t1.setText(" ");
            t2.setText(" ");
        });

        save.setOnAction(e -> {
            Integer selectedCustomerId = cb.getValue();
            if (selectedCustomerId != null) {
                customer c = new customer(selectedCustomerId, t1.getText(), t2.getText());
                hm.put(selectedCustomerId, c);

                try (PrintStream ps = new PrintStream(new FileOutputStream("c://Users//ashun//file.txt"))) {

                    for (customer cc : hm.values()) {
                        ps.println(cc.getCostomer_Id());
                        ps.println(cc.getName());
                        ps.println(cc.getAddress());
                    }

                } catch (Exception ee) {
                    ee.printStackTrace(); // Print the exception for debugging
                }
            } else {
                // Handle the case where no customer is selected from the ComboBox
            }
        });


        HBox h1 = new HBox();
        h1.setAlignment(Pos.CENTER);
        h1.setSpacing(15);
        h1.setPadding(new Insets(10, 10, 10, 10));
        h1.getChildren().addAll(l1, cb);

        HBox h2 = new HBox();

        h2.setAlignment(Pos.CENTER);
        h2.setSpacing(15);
        h2.setPadding(new Insets(10, 10, 10, 10));
        h2.getChildren().addAll(l2, t1);
        HBox h3 = new HBox();

        h3.setAlignment(Pos.CENTER);
        h3.setSpacing(15);
        h3.setPadding(new Insets(10, 10, 10, 10));
        h3.getChildren().addAll(l3, t2);
        HBox h4 = new HBox();

        h4.setAlignment(Pos.CENTER);
        h4.setSpacing(15);
        h4.setPadding(new Insets(10, 10, 10, 10));
        h4.getChildren().addAll(create, save);

        VBox v = new VBox();
        v.setAlignment(Pos.CENTER);
        v.setSpacing(15);
        v.setPadding(new Insets(10, 10, 10, 10));
        v.getChildren().addAll(h1, h2, h3, h4);

        try (Scanner ss = new Scanner(new FileInputStream("c://Users//ashun//file.txt"))) {
            int id;
            String name;
            String add;
            while (ss.hasNext()) {
                id = ss.nextInt();
                name = ss.nextLine();
                add = ss.nextLine();

                hm.put(id, new customer(id, name, add));
                if (id > count) count = id;
                cb.getItems().add(id);
            }

        } catch (Exception ee) {
        }


        cb.valueProperty().addListener(e -> {
            int c = cb.getValue();
            customer cc = hm.get(c);
            t1.setText(cc.name);
            t2.setText(cc.address);
        });

        Scene s = new Scene(v, 500, 500);
        stage.setScene(s);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
