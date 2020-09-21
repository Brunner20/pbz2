package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class EmployeeDAO {

    private DBUtil util;

    public  EmployeeDAO(){
        util= new DBUtil();
    }

    public ObservableList<Employee> findEmployeeBySexAndAge(String sex, int age) throws SQLException {
        String query ="SELECT name,birth_year FROM Employee" +
                        " WHERE sex =  "+ sex +
                        " and age =" + age + ";" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

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
            employee.setSex(set.getString("sex"));
            employee.setSubdivisionId(set.getInt("subdivision_id"));
            employee.setStartDate((GregorianCalendar) set.getObject("start_date"));//сработает ли?
            employee.setEndDate((GregorianCalendar) set.getObject("start_date"));//сработает ли?
            employees.add(employee);
        }
        return employees;
    }
}
