package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.TransferDoc;

import java.sql.Date;
import java.sql.SQLException;

public class EquipmentTransferWind {

    Controller controller;
    private TextField subdivisionId;
    private TextField equipmentId;
    private DatePicker dateTransfer;
    private Button transfer;
    private AnchorPane anchorPane;

    public EquipmentTransferWind(){
        controller =new Controller();
        configureWin();
    }

    public AnchorPane getAnchorPane() { return anchorPane; }

    private void configureWin(){
        anchorPane = new AnchorPane();

        GridPane pane = new GridPane();
        subdivisionId  =new TextField();
        equipmentId =new TextField();
        dateTransfer =new DatePicker();
        transfer =new Button("перевести");
        transfer.setOnAction(transferEv);

        subdivisionId.setPromptText("новое подраздедение");
        equipmentId.setPromptText("номер техники");
        dateTransfer.setPromptText("дата перевода");

        pane.add(equipmentId,0,0,1,1);
        pane.add(subdivisionId,0,1,1,1);
        pane.add(dateTransfer,0,2,1,1);
        pane.add(transfer,0,3,1,1);
        pane.setHgap(5);
        pane.setVgap(10);

        AnchorPane.setTopAnchor(pane,40.0);
        AnchorPane.setLeftAnchor(pane,20.0);
        anchorPane.getChildren().addAll(pane);

    }

    private final EventHandler<ActionEvent> transferEv = e -> {

        int subId;
        int eqId;
        Date date;

        try {

            if(subdivisionId.getText().isEmpty()){ throw  new NumberFormatException();}
            else subId = Integer.parseInt(subdivisionId.getText());
            if(equipmentId.getText().isEmpty())throw  new NumberFormatException();
            else eqId =Integer.parseInt(equipmentId.getText());
            if(dateTransfer.getValue()==null)throw  new NumberFormatException();
            else date = Date.valueOf(dateTransfer.getValue());

            TransferDoc doc = new TransferDoc(eqId,subId,date);
            controller.addEquipmentHistory(doc.getTransferDate(),doc.getSubdivisionId(),doc.getEquipmentId());
            controller.updateEquipmentSub(doc.getEquipmentId(), doc.getSubdivisionId());
            controller.updateEquipmentHistory(doc.getTransferDate(),doc.getEquipmentId());

        }

        catch (NumberFormatException ex){

            excep();
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
