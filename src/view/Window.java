package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.MainWindow;

import java.io.IOException;
import java.sql.SQLException;

public class Window extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
     public void start(Stage primaryStage) throws IOException, SQLException {


        EmployeeWindow window = new EmployeeWindow();
        Scene scene =new Scene(window.getAnchorPane(),1200,700);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

}
