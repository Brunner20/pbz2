package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Equipment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentDAO {

    private final DBUtil util;

    public EquipmentDAO(){

        util = new DBUtil();
    }


    //найти  всю технику
    public ObservableList<Equipment> findAllEquipment() throws SQLException {
        String query ="SELECT * FROM Equipment;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    //найти  количество техники по ее название и названию подразделения
    public int findCountEquipmentByNameAndSubdivision(String equipmentName, String subdivisionName) throws SQLException {
        String query ="SELECT count(id) FROM Equipment as eq left join Subdivision as sub on subdivision_id=sub.id"+
                "where eq.name= "+equipmentName+"and sub.name="+subdivisionName+";";
        ResultSet set= util.dbExecuteQuery(query);
        return set.getInt(0);

    }


    //обновление информации(названия) об оргтехнике
    public void updateTable(int number, String name ) throws SQLException {
        String query ="UPDATE Equipment" +
                " SET name =  "+ name +
                " WHERE number =" + number + ";" ;

        util.dbUpdate(query);

    }

    //удаление техники
    public void deleteInTable(int number ) throws SQLException {
        String query ="DELETE Equipment" +
                " WHERE number =" + number + ";" ;


        util.dbUpdate(query);
    }

    //добавление техники
    public  void  insertIntoTable( String name, String model, int year, int subId) throws SQLException {

        String query = "INSERT INTO Equipment (number,name,model,year_issue, subdivision_id)" +
                "values (sequence_employee.nextval,"+name+","+model+","+year+","+subId+");";

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
            employees.add(equipment);
        }
        return employees;
    }
}
