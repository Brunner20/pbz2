package view;

import controller.Controller;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Waybill;

import java.sql.Date;
import java.sql.SQLException;

public class WaybillTable {

    private TableView<Waybill> table;
    private Controller controller;

    private AnchorPane anchorPane;


    public WaybillTable(ObservableList<Waybill> list) throws SQLException {
        table = new TableView<>();
        controller = new Controller();
        configureWin();
        createTable(list);

    }

    public  AnchorPane getAnchorPane() { return anchorPane; }

    private void createTable(ObservableList<Waybill> waybills)  {
        table.setItems(waybills);
    }

    private void configureWin(){
        anchorPane = new AnchorPane();
        configureTable();


    }

    private  void configureTable(){
        TableColumn<Waybill,Integer> idColumn = new TableColumn<>("номер ");
        TableColumn<Waybill,String> detailColumn = new TableColumn<>("деталь");
        TableColumn<Waybill,Integer> costColumn = new TableColumn<>("стоимость ");
        TableColumn<Waybill, Date> dateColumn = new TableColumn<>("дата получения");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<>("detail"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("receiving_date"));

        table.getColumns().addAll(idColumn,detailColumn,costColumn,dateColumn);

        table.setPrefSize(600,340);
        AnchorPane.setTopAnchor(table,200.0);
        AnchorPane.setLeftAnchor(table,20.0);
        anchorPane.getChildren().addAll(table);
    }


}
