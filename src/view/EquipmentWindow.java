package view;

import DAO.EquipmentDAO;
import controller.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Equipment;
import models.EquipmentHistory;

import java.sql.Date;
import java.sql.SQLException;

public class EquipmentWindow {

    private final TableView<Equipment> tableEquip;
    private Controller controller;

    private AnchorPane anchorPane;
    private TextField numberForUpd;
    private TextField numberForDelete;
    private TextField name;
    private TextField nameUpd;
    private TextField model;
    private TextField yearIssue;
    private TextField subdivision;
    private DatePicker dateIn;

    private Button addBtn;
    private Button updateBtn;
    private Button deleteBtn;
    private Button transfer;


    public EquipmentWindow() throws SQLException {
        tableEquip = new TableView<>();
        controller = new Controller();
        configureWin();
        createTable(controller.getAllEquipment());
    }

    public AnchorPane getAnchorPane() { return anchorPane; }

    private void configureWin(){

        anchorPane = new AnchorPane();
        configureAddPane();
        configureTable();
        configureUpdateAndDelete();
        addBtn.setOnAction(addEquip);
        updateBtn.setOnAction(updateEq);
        deleteBtn.setOnAction(delEq);


    }
    private  void configureTable(){

        TableColumn<Equipment,Integer> idColumn = new TableColumn<>("номер");
        TableColumn<Equipment,String> nameColumn =new TableColumn<>("название");
        TableColumn<Equipment,String> modelColumn =new TableColumn<>("модель");
        TableColumn<Equipment,Integer> yearColumn = new TableColumn<>("год выпуска");
        TableColumn<Equipment,Integer> subdivisionColumn = new TableColumn<>("владеющее подразделение");
        TableColumn<Equipment,Integer> dateInColumn = new TableColumn<>("дата,с которой устройство принадлежит подразделени.");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("yearIssue"));
        subdivisionColumn.setCellValueFactory(new PropertyValueFactory<>("subdivisionId"));
        dateInColumn.setCellValueFactory(new PropertyValueFactory<>("date_in"));
        idColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(150);
        modelColumn.setPrefWidth(150);
        yearColumn.setPrefWidth(110);
        subdivisionColumn.setPrefWidth(220);

        tableEquip.getColumns().addAll(idColumn,nameColumn,modelColumn,yearColumn,subdivisionColumn,dateInColumn);

        transfer = new Button("переместить технику в другой отдел");
        transfer.setPrefSize(300,50);
        transfer.setOnAction(transWin);
        AnchorPane.setTopAnchor(transfer,550.0);
        AnchorPane.setLeftAnchor(transfer,500.0);

        tableEquip.setPrefSize(600,340);
        AnchorPane.setTopAnchor(tableEquip,200.0);
        AnchorPane.setLeftAnchor(tableEquip,500.0);
        anchorPane.getChildren().addAll(tableEquip,transfer);
    }

    private void configureAddPane(){

        GridPane gridForAdd = new GridPane();
        Separator vert =new Separator(Orientation.VERTICAL);
        Separator hor =new Separator(Orientation.HORIZONTAL);


        name =new TextField();
        model = new TextField();
        yearIssue = new TextField();
        subdivision = new TextField();
        dateIn =new DatePicker();
        name.setPromptText("название");
        model.setPromptText("модель");
        yearIssue.setPromptText("год выпуска");
        subdivision.setPromptText("номер подразделения");
        dateIn.setPromptText("дата начала работы в подразделении");

        addBtn = new Button("добавить");
        addBtn.setPrefSize(109,48);

        gridForAdd.add(name,0,0,1,1);
        gridForAdd.add(model,0,1,1,1);
        gridForAdd.add(yearIssue,0,2,1,1);
        gridForAdd.add(subdivision,0,3,1,1);
        gridForAdd.add(dateIn,0,4,1,1);
        gridForAdd.add(addBtn,0,5,1,1);
        gridForAdd.setHgap(5);
        gridForAdd.setVgap(10);

        vert.setPrefSize(20,350);
        hor.setPrefSize(920,5);

        AnchorPane.setLeftAnchor(gridForAdd,20.0);
        AnchorPane.setTopAnchor(gridForAdd,20.0);
        AnchorPane.setLeftAnchor(vert,410.0);
        AnchorPane.setTopAnchor(vert,10.0);
        AnchorPane.setLeftAnchor(hor,10.0);
        AnchorPane.setTopAnchor(hor,10.0);

        anchorPane.getChildren().addAll(gridForAdd,vert,hor);


    }
    private void configureUpdateAndDelete(){

        GridPane pane= new GridPane();

        numberForUpd = new TextField();
        numberForDelete =new TextField();
        nameUpd =new TextField();

        nameUpd.setPromptText("новое название");
        numberForUpd.setPromptText("номер техники для обновления");
        numberForDelete.setPromptText("номер техники для списания");

        updateBtn = new Button("обновить");
        deleteBtn = new Button("списать");


        deleteBtn.setPrefSize(160,30);
        updateBtn.setPrefSize(160,30);

        GridPane.setHalignment(updateBtn, HPos.CENTER);
        GridPane.setHalignment(deleteBtn, HPos.CENTER);

        pane.add(numberForUpd,0,0,1,1);
        pane.add(nameUpd,0,1,1,1);
        pane.add(updateBtn,0,2,1,1);
        pane.add(numberForDelete,1,0,1,1);
        pane.add(deleteBtn,1,2,1,1);
        pane.setHgap(5);
        pane.setVgap(10);

        AnchorPane.setTopAnchor(pane,20.0);
        AnchorPane.setLeftAnchor(pane,500.0);
        anchorPane.getChildren().addAll(pane);

    }

    private void createTable(ObservableList<Equipment> equipment)  {
        for(Equipment equipment1 : equipment)
            System.out.println(equipment1);
        tableEquip.setItems(equipment);

    }


    private void excep(){
        Label deleted=new Label("введены некорректные данные");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(deleted);
        Scene secondScene = new Scene(secondaryLayout, 260, 130);
        Stage newWindow = new Stage();
        newWindow.setScene(secondScene);
        newWindow.show();
    }

    private final EventHandler<ActionEvent> addEquip = e -> {

        try {

            controller.addEquipment(name.getText(),
                                        model.getText(),
                                        Integer.parseInt(yearIssue.getText()),
                                        Integer.parseInt(subdivision.getText()),
                                        Date.valueOf( dateIn.getValue()));

            createTable(controller.getAllEquipment());
            controller.addEquipmentHistory(Date.valueOf( dateIn.getValue()),
                                            Integer.parseInt(subdivision.getText()),
                                            controller.getLastEquipmentId());


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            excep();
        }


    };
    private final EventHandler<ActionEvent> delEq = e -> {

        try {
            controller.deleteEquipment(Integer.parseInt(numberForDelete.getText()));
            createTable(controller.getAllEquipment());
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            excep();
        }


    };

    private final EventHandler<ActionEvent> updateEq = e -> {
        int id ;
        String name =null;

        try {

            if(numberForUpd.getText().isEmpty()){ throw  new NumberFormatException();}
            else id = Integer.parseInt(numberForUpd.getText());
            if(!nameUpd.getText().isEmpty())
                name =nameUpd.getText();
            else throw  new NumberFormatException();


            controller.updateEquipment(id, name );
            createTable(controller.getAllEquipment());

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){

            excep();
        }


    };
    private EventHandler<ActionEvent> transWin = e -> {


            EquipmentTransferWind subdivisionWindow =new EquipmentTransferWind();
            Scene scene =new Scene(subdivisionWindow.getAnchorPane(),300,400);
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.show();


    };


}
