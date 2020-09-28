package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Employee;
import models.Subdivision;
import models.Waybill;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WaybillDAO {

    private DBUtil util;

    public WaybillDAO(){
        util =new DBUtil();
    }

    public ObservableList<Waybill> findAllWaybills() throws SQLException {
        String query ="SELECT * FROM waybill;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    public ObservableList<Waybill> findByRepair(int repair) throws SQLException {
        String query ="SELECT * FROM waybill " +
                "where repairs_id = "+repair+";" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);
    }

    public  void insertItoDB(int repair, String detail, int cost, Date date) throws SQLException {
        String query ="insert into waybill(repairs_id,detail,cost,receiving_date)" +
                "values( "+repair+", '"+detail+"', "+cost+", '"+date+"');" ;
        util.dbUpdate(query);

    }

    private ObservableList<Waybill> getListFromSet(ResultSet set) throws SQLException {

        ObservableList<Waybill> waybills = FXCollections.observableArrayList();


        while (set.next()){
            Waybill waybill =new Waybill();
            waybill.setCost(set.getInt("cost"));
            waybill.setId(set.getInt("id"));
            waybill.setDetail(set.getString("detail"));
            waybill.setReceivingDate(set.getDate("receiving_date"));
            waybill.setRepairNumber(set.getInt("repairs_id"));
            waybills.add(waybill);
        }


        return waybills;
    }
}
