package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MainWindow {

    GridPane pane;
    Scene newScene;

    public MainWindow() {
        pane = new GridPane();
    }

    public GridPane create(){

        Button getEquipment= new Button("Техники");
        getEquipment.setOnAction(tableEq);
        Button getEmployee = new Button("Работники");
        pane.add(getEmployee,0,0);
        pane.add(getEquipment,0,1);
        return pane;

    }
    private EventHandler<ActionEvent> tableEq = e -> {


    };
}
