package DAO;

import Util.DBUtil;

import java.sql.SQLException;

public class EquipmentDAO {

    private final DBUtil util;

    public EquipmentDAO(){

        util = new DBUtil();
    }

    public void updateTable(int number, String name ) throws SQLException {
        String query ="UPDATE Equipment" +
                " SET name =  "+ name +
                " WHERE number =" + number + ";" ;

        util.dbUpdate(query);

    }

    public void deleteInTable(int number ) throws SQLException {
        String query ="UPDATE Equipment" +
                " WHERE number =" + number + ";" ;


        util.dbUpdate(query);
    }

    public  void  insertIntoTable( String name, String model, int year, int subId) throws SQLException {

        String query = "INSERT INTO Equipment (number,name,model,year_issue, subdivision_id)" +
                "values (sequence_employee.nextval,"+name+","+model+","+year+","+subId+");";

        util.dbUpdate(query);

    }

}
