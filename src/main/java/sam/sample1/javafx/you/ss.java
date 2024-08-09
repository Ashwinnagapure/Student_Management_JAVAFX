package sam.sample1.javafx.you;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ss extends Application {

    @Override
    public void start(Stage primaryStage) {
        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(
                createTitledPane("Section 1", "Content for section 1"),
                createTitledPane("Section 2", "Content for section 2"),
                createTitledPane("Section 3", "Content for section 3")
        );

        ScrollPane scrollPane = new ScrollPane(accordion);
        scrollPane.setFitToWidth(true);

        VBox root = new VBox(scrollPane);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Accordion and ScrollPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
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
