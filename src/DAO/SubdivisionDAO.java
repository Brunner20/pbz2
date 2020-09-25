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


    //удаление подразделения
    public void deleteInTable(int number ) throws SQLException {
        String query ="DELETE FROM subdivision" +
                " WHERE id =" + number + ";" ;


        util.dbUpdate(query);
    }

    //добавление техники
    public  void  insertIntoTable(   String name) throws SQLException {

        String query = "INSERT INTO subdivision (name)" +
                "values ('"+name+"') ;";
        util.dbUpdate(query);

    }
    private  ObservableList<Subdivision> getListFromSet(ResultSet set) throws SQLException {

        ObservableList<Subdivision> subdivisions = FXCollections.observableArrayList();

        while (set.next()){
            Subdivision equipment =new Subdivision();
            equipment.setId(set.getInt("id"));
            equipment.setName(set.getString("name"));
            subdivisions.add(equipment);
        }
        return subdivisions;
    }
}
