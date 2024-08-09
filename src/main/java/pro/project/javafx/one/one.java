package pro.project.javafx.one;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

class student {
    public int rollno;

    public String name;
    public String grade;

    public student(int rollno,String name,  String grade) {
        this.rollno = rollno;
        this.name = name;
        this.grade = grade;
    }
    public int getRollno() {
        return rollno;
    }


    public String getName() {
        return name;
    }


    public String getGrade() {
        return grade;
    }
}


public class one extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        /* Header Section */
        Text t = new Text("Student Management System");
        t.setFont(Font.font("Times New Roman", 20));
        t.setFill(Color.WHITE);

        Button home = new Button("Home");
        Button stud1 = new Button("Students-Detail");
        stud1.setOnAction(e->openStudentSectionWindow2());
        Button stud2 = new Button("Student-Section");
        stud2.setOnAction(e->openStudentSectionWindow1());
        Button about = new Button("Student-list");
        about.setOnAction(e->openStudentListWindow());

        HBox h1 = new HBox(10, home, stud1, stud2, about);
        h1.setPadding(new Insets(10, 10, 10, 10));
        h1.setStyle("-fx-background-color:#5C5470");

        VBox v1 = new VBox(10, t, h1);

        v1.setPadding(new Insets(20));
        v1.setStyle("-fx-background-color:#352F44");
        v1.maxHeight(200);

        StackPane sp = new StackPane();
        sp.setStyle("-fx-background-color:#B9B4C7");

        Accordion a = new Accordion();
        a.getPanes().addAll(
                createTitledPane("Student Guidlines 1", "Attendence Must be 75%"),
                createTitledPane("Student Guidlines 2", "Students Should obeys all rules and regulation"),
                createTitledPane("Student Guidlines 3", "Maintain Dicipline ")
        );
        ScrollPane scrollPane = new ScrollPane(a);
        scrollPane.setFitToWidth(true);


        Rectangle r1 = new Rectangle(400,200,Color.CADETBLUE);
        r1.setArcHeight(30);
        r1.setArcWidth(30);
        r1.setEffect(new DropShadow(10,5,5,Color.GREY));


        Text t1 = new Text("A person who never made a mistake"+"\n never tried anything new. — Albert Einstein");
        t1.setTextAlignment(TextAlignment.CENTER);
        t1.setFont(new Font("Verdana Bold", 18));
        double maxWidth = r1.getWidth() - 20; // Subtracting padding
        double maxHeight = r1.getHeight() - 20; // Subtracting padding
        double fontSize = 20; // Initial font size

        t1.setFont(new Font(fontSize));

        while (t1.getBoundsInLocal().getWidth() > maxWidth || t1.getBoundsInLocal().getHeight() > maxHeight) {
            fontSize--;
            t1.setFont(new Font(fontSize));
        }


        StackPane stackPane1 = new StackPane();
        stackPane1.setPrefHeight(200);
        stackPane1.setPrefWidth(400);
        stackPane1.getChildren().addAll(r1, t1);

        Rectangle r2 = new Rectangle(400,200,Color.AQUAMARINE);
        r2.setArcHeight(30);
        r2.setArcWidth(30);
        r2.setEffect(new DropShadow(10,5,5,Color.GREY));


        Text t2 = new Text("The man who does not read books has no advantage"+ "\n over the one who cannot read them. — Mark Twain");
        t2.setTextAlignment(TextAlignment.CENTER);
        t2.setFont(new Font("Verdana Bold", 18));
        double maxWidth2 = r2.getWidth() - 20; // Subtracting padding
        double maxHeight2 = r2.getHeight() - 20; // Subtracting padding
        double fontSize2 = 20; // Initial font size

        t2.setFont(new Font(fontSize));

        while (t2.getBoundsInLocal().getWidth() > maxWidth || t2.getBoundsInLocal().getHeight() > maxHeight) {
            fontSize--;
            t2.setFont(new Font(fontSize));
        }


        StackPane stackPane2 = new StackPane();
        stackPane2.setPrefHeight(200);
        stackPane2.setPrefWidth(400);
        stackPane2.getChildren().addAll(r2, t2);

        Rectangle r3 = new Rectangle(400,200,Color.ALICEBLUE);
        r3.setArcHeight(30);
        r3.setArcWidth(30);
        r3.setEffect(new DropShadow(10,5,5,Color.GREY));


        Text t3 = new Text("Arise, awake, and stop not till"+"\n the goal is reached. - Swami Vivekananda");
        t3.setTextAlignment(TextAlignment.CENTER);
        t3.setFont(new Font("Verdana Bold", 18));
        double maxWidth3 = r3.getWidth() - 20; // Subtracting padding
        double maxHeight3 = r3.getHeight() - 20; // Subtracting padding
        double fontSize3 = 20; // Initial font size

        t2.setFont(new Font(fontSize));

        while (t3.getBoundsInLocal().getWidth() > maxWidth || t3.getBoundsInLocal().getHeight() > maxHeight) {
            fontSize--;
            t3.setFont(new Font(fontSize));
        }


        StackPane stackPane3 = new StackPane();
        stackPane3.setPrefHeight(200);
        stackPane3.setPrefWidth(400);
        stackPane3.getChildren().addAll(r3, t3);

        HBox h2 = new HBox(stackPane1,stackPane2,stackPane3);
        h2.setSpacing(25);
        h2.setPadding(new Insets(20));


        VBox root = new VBox(v1, sp,scrollPane,h2);
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();

    }
    int count =0;
    private void openStudentSectionWindow1() {
        Stage studentSectionStage = new Stage();
        studentSectionStage.initModality(Modality.APPLICATION_MODAL);
        studentSectionStage.setTitle("Student Section");

        Text t = new Text("Fill Your Details");
        t.setFont(Font.font("Times New Roman", 20));
        t.setFill(Color.BLACK);


        HashMap<Integer, student> hm = new HashMap<>();

        Font f = new Font("Times New Roman", 20);
        Label l1 = new Label("Student ID");
        l1.setFont(f);
        Label l2 = new Label("Name");
        l1.setFont(f);
        Label l3 = new Label("Grade");
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
                student c = new student(selectedCustomerId, t1.getText(), t2.getText());
                hm.put(selectedCustomerId, c);

                try (PrintStream ps = new PrintStream(new FileOutputStream("c://Users//ashun//file1.txt"))) {

                    for (student cc : hm.values()) {
                        ps.println(cc.getRollno());
                        ps.println(cc.getName());
                        ps.println(cc.getGrade());
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
        v.getChildren().addAll(t,h1, h2, h3, h4);

        try (Scanner ss = new Scanner(new FileInputStream("c://Users//ashun//file1.txt"))) {
            int id;
            String name;
            String add;
            while (ss.hasNext()) {
                id = ss.nextInt();
                name = ss.nextLine();
                add = ss.nextLine();

                hm.put(id, new student(id, name, add));
                if (id > count) count = id;
                cb.getItems().add(id);
            }

        } catch (Exception ee) {
        }


        cb.valueProperty().addListener(e -> {
            int c = cb.getValue();
            student cc = hm.get(c);
            t1.setText(cc.name);
            t2.setText(cc.grade);
        });




        Scene studentSectionScene = new Scene(v, 500, 500);
        studentSectionStage.setScene(studentSectionScene);
        studentSectionStage.showAndWait();
    }

    private void openStudentSectionWindow2() {
        Stage studentSectionStage = new Stage();
        studentSectionStage.initModality(Modality.APPLICATION_MODAL);
        studentSectionStage.setTitle("Student Detail");

        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        x.setLabel("Student");
        y.setLabel("Student Grades");

        LineChart<Number,Number>lc = new LineChart<>(x,y);
        lc.setTitle("Student Data");

        XYChart.Series<Number,Number>ac = new XYChart.Series<>();
        ac.setName("Students Information");
        ac.getData().add(new XYChart.Data<>(1, 5));
        ac.getData().add(new XYChart.Data<>(2, 10));
        ac.getData().add(new XYChart.Data<>(3, 8));
        ac.getData().add(new XYChart.Data<>(4, 15));
        lc.getData().add(ac);

        PieChart pieChart = new PieChart();
        pieChart.setTitle("Pie Chart Students Data");

        PieChart.Data pieData1 = new PieChart.Data("Student 1", 30);
        PieChart.Data pieData2 = new PieChart.Data("Student 2", 20);
        PieChart.Data pieData3 = new PieChart.Data("Student 3", 25);
        PieChart.Data pieData4 = new PieChart.Data("Student 4 ",25);

        pieChart.getData().addAll(pieData1, pieData2, pieData3);

        HBox h2 = new HBox(lc,pieChart);
        h2.setSpacing(20);

        CategoryAxis xAxisBar = new CategoryAxis();
        NumberAxis yAxisBar = new NumberAxis();
        xAxisBar.setLabel("Subject");
        yAxisBar.setLabel("Grades");

        BarChart<String, Number> barChart = new BarChart<>(xAxisBar, yAxisBar);
        barChart.setTitle("Bar Chart  Students Data");

        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        barSeries.setName("Bar Data Series");
        barSeries.getData().add(new XYChart.Data<>("Student 1", 8));
        barSeries.getData().add(new XYChart.Data<>("Student 2", 15));
        barSeries.getData().add(new XYChart.Data<>("Student 3", 5));
        barSeries.getData().add(new XYChart.Data<>("Student 4", 12));

        barChart.getData().add(barSeries);

        VBox v2 = new VBox(h2,barChart);
        v2.setPadding(new Insets(20));
        v2.setSpacing(25);

        Scene studentSectionScene = new Scene(v2, 500, 500);
        studentSectionStage.setScene(studentSectionScene);
        studentSectionStage.showAndWait();
    }

    private void openStudentListWindow() {
        Stage studentListStage = new Stage();
        studentListStage.initModality(Modality.APPLICATION_MODAL);
        studentListStage.setTitle("Student List");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        try (Scanner scanner = new Scanner(new FileInputStream("c://Users//ashun//file1.txt"))) {
            StringBuilder studentList = new StringBuilder();
            while (scanner.hasNext()) {
                int rollno = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                String name = scanner.nextLine();
                String grade = scanner.nextLine();
                studentList.append("Roll No: ").append(rollno).append("\n")
                        .append("Name: ").append(name).append("\n")
                        .append("Grade: ").append(grade).append("\n\n");
            }
            textArea.setText(studentList.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        VBox vbox = new VBox(textArea);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 400, 300);
        studentListStage.setScene(scene);
        studentListStage.showAndWait();
    }
    private TitledPane createTitledPane(String title, String content) {
        TitledPane pane = new TitledPane(title, new VBox());
        pane.setContent(new ScrollPane(createContent(content)));
        return pane;
    }

    private VBox createContent(String text) {
        VBox content = new VBox();
        content.setPadding(new Insets(10));
        content.getChildren().add(new javafx.scene.control.Label(text));
        return content;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
