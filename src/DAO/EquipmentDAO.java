package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Equipment;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentDAO {

    private final DBUtil util;

    public EquipmentDAO(){

        util = new DBUtil();
    }


    //найти  всю технику
    public ObservableList<Equipment> findAllEquipment() throws SQLException {
        String query ="SELECT * FROM equipment;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    public Integer findLastEquipmentId() throws SQLException {
        String query ="SELECT number FROM equipment\n "
                +"ORDER BY number desc\n" +
                "LIMIT 1 ;";
        ResultSet set= util.dbExecuteQuery(query);
        set.first();
        return set.getInt("number");

    }

    //найти  количество техники по ее название и названию подразделения
    public int findCountEquipmentByNameAndSubdivision(String equipmentName, int subdivision) throws SQLException {
        String query ="SELECT count(id) FROM equipment left join subdivision  on subdivision_id=subdivision.id "+
                "where equipment.name= '"+equipmentName+" ' and subdivision.id= "+subdivision+";";
        ResultSet set= util.dbExecuteQuery(query);
        set.first();
        return set.getInt("count(id)");

    }


    //обновление информации(названия) об оргтехнике
    public void updateTable(int number, String name ) throws SQLException {
        String query ="UPDATE Equipment" +
                " SET name =  ' "+ name +
                "' WHERE number =" + number + ";" ;

        util.dbUpdate(query);

    }


    public void updateSub(int id, int sub) throws SQLException {
        String query ="UPDATE  equipment " +
                "SET  subdivision_id = "+sub+" "+
                "WHERE number =" + id+";";
        util.dbUpdate(query);


    }

    //удаление техники
    public void deleteInTable(int number ) throws SQLException {
        String query ="DELETE FROM Equipment" +
                " WHERE number =" + number + ";" ;


        util.dbUpdate(query);
    }

    //добавление техники
    public  void  insertIntoTable(String name, String model, int year, int subId, Date date) throws SQLException {

        String query = "INSERT INTO Equipment (name,model,year_issue, subdivision_id,date_in)" +
                "values ( '"+name+" ', '"+model+"' ,"+year+","+subId+",'"+date+"');";

        util.dbUpdate(query);

    }
    private  ObservableList<Equipment> getListFromSet(ResultSet set) throws SQLException {

        ObservableList<Equipment> employees = FXCollections.observableArrayList();

        while (set.next()){
            Equipment equipment =new Equipment();
            equipment.setModel(set.getString("model"));
            equipment.setNumber(set.getInt("number"));
            equipment.setName(set.getString("name"));
            equipment.setYearIssue(set.getInt("year_issue"));
            equipment.setSubdivisionId(set.getInt("subdivision_id"));
            equipment.setDateIn(set.getDate("date_in"));
            employees.add(equipment);
        }
        return employees;
    }
}
