package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Equipment;
import models.EquipmentHistory;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentHistoryDAO {

    private final DBUtil util;

    public EquipmentHistoryDAO(){

        util = new DBUtil();
    }


    public ObservableList<EquipmentHistory> findAllEquipmentHistory() throws SQLException {
        String query ="SELECT * FROM equipment_history;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }



    public  void  insertIntoTable(Date dateIn, Date dateOut, int subdivisionId, int equipmentId) throws SQLException {

        String query = "INSERT INTO equipment_history (subdivision_id,equipment_id,date_in, date_out)" +
                "values ( "+subdivisionId+" , "+equipmentId+" ,'"+dateIn+"','"+dateOut+"');";

        util.dbUpdate(query);

    }
    private  ObservableList<EquipmentHistory> getListFromSet(ResultSet set) throws SQLException {

        ObservableList<EquipmentHistory> equipmentHistories = FXCollections.observableArrayList();

        while (set.next()){
            EquipmentHistory equipmentHistory =new EquipmentHistory();
            equipmentHistory.setSubdivisionId(set.getInt("subdivision_id"));
            equipmentHistory.setEquipmentId(set.getInt("equipment_id"));
            equipmentHistory.setDateIn(set.getDate("date_in"));
            equipmentHistory.setDateOut(set.getDate("date_out"));

            equipmentHistories.add(equipmentHistory);
        }
        return equipmentHistories;
    }
}

