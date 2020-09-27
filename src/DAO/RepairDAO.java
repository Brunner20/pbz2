package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Employee;
import models.Repairs;
import models.Subdivision;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairDAO {

    private final DBUtil util;

    public RepairDAO() { this.util = new DBUtil(); }

    public ObservableList<Repairs> findAllRepairs() throws SQLException {

        String query ="SELECT * FROM repairs;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    public  void insertIntoDB(Date dateRepairs, String type, int term, String nameTake,
                              int numberTake, String nameGive, int numberGive,String nameFix,
                              int numberFix,String positionFix,int waybillId) throws SQLException {

        String query = "INSERT INTO repairs(date_repairs,type,term,name_take,number_take,name_give,number_give,name_fix,number_fix," +
                "position_fix) " +
                "values ( "+dateRepairs+", ' "+type+"',"+term+", '"+nameTake+"', "+numberTake+", '"+
                nameGive+"', "+numberGive+", '"+nameFix+"', "+numberFix+", '"+positionFix+"', "+waybillId+");";

        util.dbUpdate(query);

    }

    private  ObservableList<Repairs> getListFromSet(ResultSet set) throws SQLException {

        ObservableList<Repairs> repairs = FXCollections.observableArrayList();

        while (set.next()){
            Repairs repairs1 =new Repairs();
            repairs1.setId(set.getInt("id"));
            repairs1.setDateRepairs(set.getDate("date_repairs"));
            repairs1.setNameFix(set.getString("name_fix"));
            repairs1.setNameGive(set.getString("name_give"));
            repairs1.setNameTake(set.getString("name_take"));
            repairs1.setNumberFix(set.getInt("number_fix"));
            repairs1.setNumberGive(set.getInt("number_give"));
            repairs1.setNumberTake(set.getInt("number_take"));
            repairs1.setPositionFix(set.getString("position_fix"));
            repairs1.setTerm(set.getInt("term"));
            repairs1.setType(set.getString("type"));
            repairs.add(repairs1);
        }
        return repairs;
    }
}
