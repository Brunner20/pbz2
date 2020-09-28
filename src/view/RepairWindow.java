package view;

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
import models.Employee;
import models.Repairs;

import java.sql.Date;
import java.sql.SQLException;



public class RepairWindow {

    private  TableView<Repairs> table;
    private Controller controller;

    private AnchorPane anchorPane;
    private TextField id;
    private TextField type;
    private TextField term;
    private TextField nameTake;
    private TextField numberTake;
    private TextField nameGive;
    private TextField numberGive;
    private TextField nameFix;
    private TextField numberFix;
    private TextField positionFix;
    private TextField equipment;
    private DatePicker dateRepairs;

    private Button add;
    private Button waybillBtn;


    public RepairWindow() throws SQLException {
        table = new TableView<>();
        controller = new Controller();
        configureWin();
        createTable(controller.getAllRepairs());

    }

    public AnchorPane getAnchorPane() { return anchorPane; }

    private void createTable(ObservableList<Repairs> repairs)  {
        //for (Repairs repairs1: repairs) System.out.println(repairs1.getNameFix());
        table.setItems(repairs);
    }

    private void configureWin(){
        anchorPane = new AnchorPane();
        configureAddEmployeePane();
        configureTable();
        configureSearch();
        waybillBtn.setOnAction(waybillHandler);
        add.setOnAction(addEmp);

    }
    private void configureAddEmployeePane(){

        GridPane pane = new GridPane();
        Separator vert =new Separator(Orientation.VERTICAL);
        Separator hor =new Separator(Orientation.HORIZONTAL);

        type =new TextField();
        term = new TextField();
        nameTake = new TextField();
        numberTake = new TextField();
        numberGive = new TextField();
        nameGive = new TextField();
        nameFix = new TextField();
        numberFix = new TextField();
        positionFix = new TextField();
        dateRepairs =new DatePicker();
        equipment= new TextField();


        type.setPromptText("вид ремонта");
        term.setPromptText("срок ремонта");
        nameTake.setPromptText("ФИО сотрудника, который принял технику в ремонт");
        numberTake.setPromptText("номер сотрудника, который принял технику в ремонт");
        nameGive.setPromptText("ФИО сотрудника, который отдал технику в ремонт");
        numberGive.setPromptText("номер сотрудника, который отдал технику в ремонт");
        nameFix.setPromptText("ФИО сотрудника, который ремонтирует");
        numberFix.setPromptText("номер сотрудника, который ремонтирует");
        positionFix.setPromptText("должность сотрудника, который ремонтирует");
        dateRepairs.setPromptText("дата ремонта");
        equipment.setPromptText("номер техники");

        add = new Button("добавить");
        add.setPrefSize(109,48);


        pane.add(dateRepairs,0,0,1,1);
        pane.add(type,0,1,1,1);
        pane.add(term,0,2,1,1);
        pane.add(nameGive,0,3,1,1);
        pane.add(numberGive,0,4,1,1);
        pane.add(nameTake,0,5,1,1);
        pane.add(numberTake,0,6,1,1);
        pane.add(nameFix,0,7,1,1);
        pane.add(numberFix,0,8,1,1);
        pane.add(positionFix,0,9,1,1);
        pane.add(equipment,0,10,1,1);
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
    private  void configureTable(){
        TableColumn<Repairs,Integer> idColumn = new TableColumn<>("номер ремонта");
        TableColumn<Repairs,Date> dateColumn = new TableColumn<>("дата ремонта");
        TableColumn<Repairs,String> typeColumn = new TableColumn<>("вид ремонта");
        TableColumn<Repairs,Integer> termColumn = new TableColumn<>("срок ремонта");
        TableColumn<Repairs,String> nameGiveColumn = new TableColumn<>("ФИО сотрудника, который отдал технику в ремонт");
        TableColumn<Repairs,Integer> numberGiveColumn = new TableColumn<>("номер сотрудника, который отдал технику в ремонт");
        TableColumn<Repairs,String> nameTakeColumn = new TableColumn<>("ФИО сотрудника, который принял технику в ремонт");
        TableColumn<Repairs,Integer> numberTakeColumn = new TableColumn<>("номер сотрудника, который принял технику в ремонт");
        TableColumn<Repairs, String> nameFixColumn = new TableColumn<>("ФИО сотрудника, который ремонтирует");
        TableColumn<Repairs, Integer> numberFixColumn = new TableColumn<>("номер сотрудника, который ремонтирует");
        TableColumn<Repairs, String> positionFixColumn = new TableColumn<>("должность сотрудника, который ремонтирует");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateRepairs"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        termColumn.setCellValueFactory(new PropertyValueFactory<>("term"));
        nameTakeColumn.setCellValueFactory(new PropertyValueFactory<>("nameTake"));
        numberTakeColumn.setCellValueFactory(new PropertyValueFactory<>("numberTake"));
        nameGiveColumn.setCellValueFactory(new PropertyValueFactory<>("nameGive"));
        numberGiveColumn.setCellValueFactory(new PropertyValueFactory<>("numberGive"));
        nameFixColumn.setCellValueFactory(new PropertyValueFactory<>("nameFix"));
        numberFixColumn.setCellValueFactory(new PropertyValueFactory<>("numberFix"));
        positionFixColumn.setCellValueFactory(new PropertyValueFactory<>("positionFix"));

        table.getColumns().addAll(idColumn,dateColumn,typeColumn,termColumn,nameGiveColumn,numberGiveColumn,nameTakeColumn,
                numberTakeColumn,nameFixColumn,positionFixColumn);
        table.setPrefSize(720,340);

        AnchorPane.setTopAnchor(table,150.0);
        AnchorPane.setLeftAnchor(table,450.0);
        anchorPane.getChildren().addAll(table);
    }

    private void configureSearch(){

        GridPane pane =new GridPane();
        waybillBtn= new Button("получить накладную");
        waybillBtn.setPrefSize(180,48);
        id = new TextField();
        id.setPromptText("номер ремнота");

        pane.add(id,0,0,1,1);
        pane.add(waybillBtn,0,1,1,1);


        AnchorPane.setTopAnchor(pane,50.0);
        AnchorPane.setLeftAnchor(pane,450.0);
        anchorPane.getChildren().addAll(pane);

    }



    private final EventHandler<ActionEvent> addEmp = e -> {

        Date date;
        String typeS,nameTakeS,nameGiveS,nameFixS,positionFixS;
        int termI,numberTakeI,numberGiveI,numberFixI,equip;

        try {

            if(dateRepairs.getValue()==null){ throw  new NumberFormatException();}
            else date = Date.valueOf(dateRepairs.getValue());
            if(term.getText().isEmpty())throw  new NumberFormatException();
            else termI =Integer.parseInt(term.getText());
            if(nameTake.getText()==null)throw  new NumberFormatException();
            else nameTakeS = nameTake.getText();
            if(type.getText()==null)throw  new NumberFormatException();
            else typeS = type.getText();
            if(numberTake.getText().isEmpty())throw  new NumberFormatException();
            else numberTakeI =Integer.parseInt(numberTake.getText());
            if(nameGive.getText()==null)throw  new NumberFormatException();
            else nameGiveS = nameGive.getText();
            if(numberGive.getText().isEmpty())throw  new NumberFormatException();
            else numberGiveI =Integer.parseInt(numberGive.getText());
            if(nameFix.getText()==null)throw  new NumberFormatException();
            else nameFixS = nameFix.getText();
            if(numberFix.getText().isEmpty())throw  new NumberFormatException();
            else numberFixI =Integer.parseInt(numberFix.getText());
            if(positionFix.getText()==null)throw  new NumberFormatException();
            else positionFixS = positionFix.getText();
            if(equipment.getText().isEmpty())throw  new NumberFormatException();
            else equip =Integer.parseInt(equipment.getText());


            controller.addRepairs(equip,date,typeS,termI,nameTakeS,numberTakeI,nameGiveS,
                    numberGiveI,nameFixS,numberFixI,positionFixS);

            createTable(controller.getAllRepairs());
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            excep();
        }


    };

    private EventHandler<ActionEvent> waybillHandler = e -> {

        int idIn;
        try {
            if(id.getText().isEmpty()){ throw  new NumberFormatException();}
            else idIn = Integer.parseInt(id.getText());

            WaybillTable subdivisionWindow =new WaybillTable(controller.getWaybillByRepair(idIn));
            Scene scene =new Scene(subdivisionWindow.getAnchorPane(),720,600);
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
