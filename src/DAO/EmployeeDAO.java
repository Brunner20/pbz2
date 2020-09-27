package DAO;

import Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    private  final DBUtil util;
    private ResultSet set;

    public  EmployeeDAO(){
        util= new DBUtil();
        set = null;
    }



    //найти  всех сотридников
    public ObservableList<Employee> findAllEmployee() throws SQLException {

        String query ="SELECT * FROM Employee;" ;
        ResultSet set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    //найти сотридников по полу и возрасту
    public ObservableList<Employee> findEmployeeByGenderAndAge(String gender, int age) throws SQLException {
        String query ="SELECT * FROM Employee" +
                        " WHERE gender =  '"+ gender +
                        "' and age =" + age + ";" ;
        set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    //найти сотрудников по подразделению
    public ObservableList<Employee> findEmployeeBySubdivision(int subdivisionId) throws SQLException {
        String query ="SELECT * FROM employee" +
                " WHERE subdivision_id =  "+ subdivisionId + ";" ;
         set= util.dbExecuteQuery(query);
        return getListFromSet(set);

    }


    //добавление сотрудника
    public  void insertIntoDB(int age, String name, int birthYear, String gender, int subdivisionId,
                              String position, Date startDate, Date endDate) throws SQLException {

        String query = "INSERT INTO employee(age,name,birth_year,gender,subdivision_id,position,start_date,end_date) " +
                "values ( "+age+", ' "+name+"',"+birthYear+", '"+gender+"', "+subdivisionId+", '"+
                position+"', '"+startDate+"', '"+endDate+"');";

        util.dbUpdate(query);

    }

    //обновление информации о сотруднике
    public void updateDB(int id, int age,String position,Date date) throws SQLException {
        int counter =0 ;

        String query ="UPDATE Employee \n" ;
            if(age!=0) {
                counter++;
                query+="SET age = "+age+"\n ";
            }
            if(position != null) {
                if(counter>0) query+=" , ";
                else query+=" SET ";
                counter++;
                query+= "  position = '"+position+"' \n";
            }
            if(date != null)  {
                if(counter>0) query+=" , ";
                else query+=" SET ";
                query+= "  end_date = '"+date+"' \n";}

        query+= " WHERE id =" + id + ";" ;
        util.dbUpdate(query);

    }

    //удаление сотрудника
    public void deleteInDB(int id ) throws SQLException {
        String query ="DELETE FROM employee" +
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
            employee.setStartDate(set.getDate("start_date"));
            employee.setEndDate(set.getDate("end_date"));
            employees.add(employee);
        }


        return employees;
    }


}
