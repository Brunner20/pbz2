package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainWindow {

    AnchorPane anchorPane;


    public MainWindow() {
        anchorPane =new AnchorPane();
        configureWin();
    }

    public AnchorPane getAnchorPane() { return anchorPane; }

    private void configureWin(){

        GridPane pane = new GridPane();
        Button getEquipment= new Button("Техника");
        Button getEmployee = new Button("Работники");
        Button getsubdivision = new Button("Подразделения");
        Button getRepair =new Button("ремонт");
        Button getWay = new Button("накладные");
        getEquipment.setPrefSize(140,48);
        getEmployee.setPrefSize(140,48);
        getsubdivision.setPrefSize(140,48);
        getWay.setPrefSize(140,48);
        getRepair.setPrefSize(140,48);

        getEquipment.setOnAction(tableEq);
        getEmployee.setOnAction(tableEmp);
        getsubdivision.setOnAction(tableSub);
        getRepair.setOnAction(tableRep);
        getWay.setOnAction(tableWay);

        pane.add(getEmployee,0,0);
        pane.add(getEquipment,0,1);
        pane.add(getsubdivision,0,2);
        pane.add(getRepair,0,3);
        pane.add(getWay,0,4);
        pane.setHgap(5);
        pane.setVgap(10);
        AnchorPane.setLeftAnchor(pane,100.0);
        AnchorPane.setTopAnchor(pane,50.0);
        anchorPane.getChildren().addAll(pane);
    }
    private EventHandler<ActionEvent> tableEq = e -> {

        try {
            EquipmentWindow equipmentWindow =new EquipmentWindow();
            Scene scene =new Scene(equipmentWindow.getAnchorPane(),1200,700);
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };

    private EventHandler<ActionEvent> tableSub = e -> {

        try {
            SubdivisionWindow subdivisionWindow =new SubdivisionWindow();
            Scene scene =new Scene(subdivisionWindow.getAnchorPane(),600,700);
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };

    private EventHandler<ActionEvent> tableEmp = e -> {

        try {
            EmployeeWindow employeeWindow =new EmployeeWindow();
            Scene scene =new Scene(employeeWindow.getAnchorPane(),1200,700);
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };

    private EventHandler<ActionEvent> tableRep = e -> {

        try {
            RepairWindow repairWindow =new RepairWindow();
            Scene scene =new Scene(repairWindow.getAnchorPane(),1200,700);
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };

    private EventHandler<ActionEvent> tableWay = e -> {

        try {
            WaybillWindow waybillWindow =new WaybillWindow();
            Scene scene =new Scene(waybillWindow.getAnchorPane(),1200,700);
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };
}
