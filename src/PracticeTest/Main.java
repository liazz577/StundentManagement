package PracticeTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main extends Application {
    public static Stage bStage;
    public static Integer width = 800;
    public static Integer height = 800;
    @Override
    public void start(Stage primaryStage) throws Exception {
        bStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("HOME");
        primaryStage.setScene(new Scene(root,width,height));
        primaryStage.show();
    }
    public class Student_Save extends Application {
        @Override
        public void start(Stage myStage) throws Exception{
            myStage.setTitle("StudentCollection");
            Button btn = new Button("Save as");
            btn.setLayoutX(200);
            btn.setLayoutY(200);
            TextField txt = new TextField();
            txt.setLayoutX(200);
            txt.setLayoutY(200);
            Pane pane1 = new Pane();
            pane1.getChildren().addAll(btn,txt);
            myStage.setScene(new Scene(pane1,400,400));
            myStage.show();
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser FC = new FileChooser();
                    FC.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Add All","*"));
                    FC.setTitle("Save your file");
                    File file = FC.showSaveDialog(myStage);
                    if (file != null) {
                        try {
                            PrintStream printS = new PrintStream(file);
                            printS.println(txt.getText());
                            printS.flush();
                        } catch (FileNotFoundException e) {
                            System.out.println("ur file can't Save");
                        }
                    }
                }
            });
            pane1.getChildren().addAll(btn,txt);
            myStage.setScene(new Scene(pane1,400,400));
            myStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
