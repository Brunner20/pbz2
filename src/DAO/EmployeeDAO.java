package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeDAO {

    private  final DBUtil util;

    public  EmployeeDAO(){
        util= new DBUtil();
    }



    //найти  всех сотридников
    public ObservableList<Employee> findAllEmployee() throws SQLException {
        String query ="SELECT * FROM Employee;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    //найти сотридников по полу и возрасту
    public ObservableList<Employee> findEmployeeBySexAndAge(String gender, int age) throws SQLException {
        String query ="SELECT name,birth_year FROM Employee" +
                        " WHERE sex =  "+ gender +
                        " and age =" + age + ";" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    //найти сотрудников по подразделению
    public ObservableList<Employee> findEmployeeBySubdivision(int subdivisionId) throws SQLException {
        String query ="SELECT name,birth_year FROM Employee" +
                " WHERE subdivision_id =  "+ subdivisionId + ";" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }


    //добавление сотрудника
    public  void  insertIntoTable(int age, String name, int birthYear, String gender, int subdivisionId,
                                  String position, Date startDate, Date endDate) throws SQLException {

        String query = "INSERT INTO Employee " +
                "values (sequence_employee.nextval,"+age+","+name+","+birthYear+","+gender+","+subdivisionId+","+
                position+","+startDate+","+endDate+");";

        util.dbUpdate(query);

    }

    //обновление информации о сотруднике
    public void updateTable(int id, int age) throws SQLException {
        String query ="UPDATE Employee" +
                " SET age =  "+ age +
                " WHERE id =" + id + ";" ;

        util.dbUpdate(query);

    }

    //удаление сотрудника
    public void deleteInTable(int id ) throws SQLException {
        String query ="DELETE Employee" +
                " WHERE id =" + id + ";" ;


        util.dbUpdate(query);
    }

    private  ObservableList<Employee> getListFromSet(ResultSet set) throws SQLException {

        ObservableList<Employee> employees =FXCollections.observableArrayList();

        while (set.next()){
            Employee employee =new Employee();
            employee.setAge(set.getInt("age"));
            employee.setId(set.getInt("id"));
            employee.setBirthYear(set.getInt("birth_year"));
            employee.setName(set.getString("name"));
            employee.setPosition(set.getString("position"));
            employee.setGender(set.getString("gender"));
            employee.setSubdivisionId(set.getInt("subdivision_id"));
            employee.setStartDate((GregorianCalendar) set.getObject("start_date"));//сработает ли?
            employee.setEndDate((GregorianCalendar) set.getObject("start_date"));//сработает ли?
            employees.add(employee);
        }
        return employees;
    }
}
