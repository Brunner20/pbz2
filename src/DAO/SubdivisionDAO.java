package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Subdivision;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubdivisionDAO {

    private final DBUtil util;

    public SubdivisionDAO(){

        util = new DBUtil();
    }


    //найти  все подразделения
    public ObservableList<Subdivision> findAllSubdivision() throws SQLException {
        String query ="SELECT * FROM subdivision;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }



    public  String findSubName() throws SQLException {
        String query ="select name from (select name,max(count) from (select subdivision.name, count(repairs.id) as count from repairs \n" +
                "\tleft join equipment on repairs.equipment_number =equipment.number \n" +
                "\tleft join subdivision on subdivision_id = subdivision.id\n" +
                "group by subdivision.name) as tab) as t\n" ;
        ResultSet set= util.dbExecuteQuery(query);

        set.first();
        return set.getString("name");



    }


    //удаление подразделения
    public void deleteInTable(int number ) throws SQLException {
        String query ="DELETE FROM subdivision" +
                " WHERE id =" + number + ";" ;


        util.dbUpdate(query);
    }

    //добавление техники
    public  void  insertIntoTable(String name) throws SQLException {

        String query = "INSERT INTO subdivision (name)" +
                "values ('"+name+"') ;";
        util.dbUpdate(query);

    }
    private  ObservableList<Subdivision> getListFromSet(ResultSet set) throws SQLException {

        ObservableList<Subdivision> subdivisions = FXCollections.observableArrayList();

        while (set.next()){
            Subdivision subdivision =new Subdivision();
            subdivision.setId(set.getInt("id"));
            subdivision.setName(set.getString("name"));
            subdivisions.add(subdivision);
        }
        return subdivisions;
    }
}
