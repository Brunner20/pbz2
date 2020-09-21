package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.MainWindow;

import java.io.IOException;

public class Window extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        MainWindow window =new MainWindow();
        GridPane pane1= window.create();
        Scene scene =new Scene(pane1,800,500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
