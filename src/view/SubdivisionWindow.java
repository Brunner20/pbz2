package view;

import DAO.SubdivisionDAO;
import controller.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Subdivision;

import java.sql.SQLException;

public class SubdivisionWindow {

    private final TableView<Subdivision> tableSub;
    private Controller controller;

    private AnchorPane anchorPane;
    private TextField id;
    private TextField name;
    private Button add;
    private Button delete;
    private Button getMaxBtn;

    public SubdivisionWindow() throws SQLException {
        tableSub = new TableView<>();
        controller = new Controller();
        configureWin();
        createTable(controller.getAllSubdivision());
    }

    public AnchorPane getAnchorPane() { return anchorPane; }

    private void configureWin(){

        anchorPane = new AnchorPane();
        configureAddAndSearchPane();
        configureTable();
        add.setOnAction(addSub);
        delete.setOnAction(delSub);
        getMaxBtn.setOnAction(getMax);

    }
    private  void configureTable(){

        TableColumn<Subdivision,Integer> idColumn = new TableColumn<>("номер");
        TableColumn<Subdivision,String> nameColumn =new TableColumn<>("название");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setPrefWidth(150);
        nameColumn.setPrefWidth(230);
        tableSub.getColumns().addAll(idColumn,nameColumn);
        tableSub.setPrefSize(380,300);

        getMaxBtn =new Button("получиать подразделение с макс. кол-вом ремонтом");
        AnchorPane.setLeftAnchor(getMaxBtn,100.0);
        AnchorPane.setTopAnchor(getMaxBtn,480.0);
        AnchorPane.setTopAnchor(tableSub,150.0);
        AnchorPane.setLeftAnchor(tableSub,100.0);
        anchorPane.getChildren().addAll(tableSub,getMaxBtn);
    }

    private void createTable(ObservableList<Subdivision> subdivisions)  {
          tableSub.setItems(subdivisions);
    }

    private void configureAddAndSearchPane(){

        GridPane pane =new GridPane();
        id =new TextField();
        name =new TextField();
        add =new Button("добавить");
        delete =new Button("удалить");
        name.setPromptText("название подразделения");
        id.setPromptText("номер подразделеня");

        pane.add(name,0,0,1,1);
        pane.add(add,0,1,1,1);
        pane.add(id,1,0,1,1);
        pane.add(delete,1,1,1,1);
        pane.setHgap(5);
        pane.setVgap(10);

        AnchorPane.setTopAnchor(pane,20.0);
        AnchorPane.setLeftAnchor(pane,100.0);
        anchorPane.getChildren().addAll(pane);

    }

    private final EventHandler<ActionEvent> addSub = e -> {

        try {
            controller.addSubdivision(name.getText());
            createTable(controller.getAllSubdivision());
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            excep();
        }


    };

    private final EventHandler<ActionEvent> delSub = e -> {

        try {
            controller.deleteSubdivision(Integer.parseInt(id.getText()));
            createTable(controller.getAllSubdivision());
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

    private final EventHandler<ActionEvent> getMax = e -> {

        try {

            Label deleted=new Label(controller.getSubdivisionWithMaxRepair());
            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(deleted);
            Scene secondScene = new Scene(secondaryLayout, 260, 130);
            Stage newWindow = new Stage();
            newWindow.setScene(secondScene);
            newWindow.show();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            excep();
        }
    };

}
