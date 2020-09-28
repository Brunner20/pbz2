package view;

import controller.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Waybill;

import java.sql.Date;
import java.sql.SQLException;

public class WaybillWindow {


    private TableView<Waybill> table;
    private Controller controller;

    private AnchorPane anchorPane;
    private TextField detail;
    private TextField cost;
    private DatePicker date;
    private TextField repair;

    private Button add;


    public WaybillWindow() throws SQLException {
        table = new TableView<>();
        controller = new Controller();
        configureWin();
        createTable(controller.getAllWaybills());

    }

    public AnchorPane getAnchorPane() { return anchorPane; }

    private void createTable(ObservableList<Waybill> waybills)  {
        table.setItems(waybills);
    }

    private void configureWin(){
        anchorPane = new AnchorPane();
        configureAddEmployeePane();
        configureTable();
        add.setOnAction(addWay);

    }

    private  void configureTable(){
        TableColumn<Waybill,Integer> idColumn = new TableColumn<>("номер ");
        TableColumn<Waybill,String> detailColumn = new TableColumn<>("деталь");
        TableColumn<Waybill,Integer> costColumn = new TableColumn<>("стоимость ");
        TableColumn<Waybill,Date> dateColumn = new TableColumn<>("дата получения");
        TableColumn<Waybill,Integer> repairColumn = new TableColumn<>("номер ремонта");


        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<>("detail"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("receiving_date"));
        repairColumn.setCellValueFactory(new PropertyValueFactory<>("repairs_id"));

        table.getColumns().addAll(idColumn,detailColumn,costColumn,dateColumn,repairColumn);

        table.setPrefSize(720,340);
        AnchorPane.setTopAnchor(table,200.0);
        AnchorPane.setLeftAnchor(table,450.0);
        anchorPane.getChildren().addAll(table);
    }

    private void configureAddEmployeePane(){

        GridPane pane = new GridPane();
        Separator vert =new Separator(Orientation.VERTICAL);
        Separator hor =new Separator(Orientation.HORIZONTAL);

        detail =new TextField();
        cost = new TextField();
        date = new DatePicker();
        repair = new TextField();

        detail.setPromptText("деталь");
        cost.setPromptText("стоимость");
        date.setPromptText("дата получения");
        repair.setPromptText("номер ремонта");


        add = new Button("добавить");
        add.setPrefSize(109,48);



        pane.add(detail,0,1,1,1);
        pane.add(cost,0,2,1,1);
        pane.add(date,0,5,1,1);
        pane.add(repair,0,6,1,1);
        pane.add(add,0,12,1,1);
        pane.setHgap(5);
        pane.setVgap(10);

        vert.setPrefSize(20,350);
        hor.setPrefSize(920,5);

        AnchorPane.setLeftAnchor(pane,20.0);
        AnchorPane.setTopAnchor(pane,20.0);
        AnchorPane.setLeftAnchor(vert,410.0);
        AnchorPane.setTopAnchor(vert,10.0);
        AnchorPane.setLeftAnchor(hor,10.0);
        AnchorPane.setTopAnchor(hor,10.0);

        anchorPane.getChildren().addAll(pane,vert,hor);


    }

    private final EventHandler<ActionEvent> addWay = e -> {

        Date dateV;
        String detailV;
        int costV,repairV;
        try {

            if(date.getValue()==null){ throw  new NumberFormatException();}
            else dateV = Date.valueOf(date.getValue());
            if(cost.getText().isEmpty())throw  new NumberFormatException();
            else costV =Integer.parseInt(cost.getText());
            if(detail.getText()==null)throw  new NumberFormatException();
            else detailV = detail.getText();
            if(repair.getText().isEmpty())throw  new NumberFormatException();
            else repairV =Integer.parseInt(repair.getText());

            controller.addWaybill(repairV,detailV,costV,dateV);
            createTable(controller.getAllWaybills());

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            excep();
        }


    };



    private void excep(){
        Label deleted=new Label("введены некорректные данные");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(deleted);
        Scene secondScene = new Scene(secondaryLayout, 260, 130);
        Stage newWindow = new Stage();
        newWindow.setScene(secondScene);
        newWindow.show();
    }
}
