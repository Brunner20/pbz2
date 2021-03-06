package controller;

import DAO.*;
import javafx.collections.ObservableList;
import models.*;

import java.sql.Date;
import java.sql.SQLException;

public class Controller {

    EmployeeDAO employeeDAO;
    EquipmentDAO equipmentDAO;
    EquipmentHistoryDAO equipmentHistoryDAO;
    SubdivisionDAO subdivisionDAO;
    RepairDAO repairDAO;
    WaybillDAO waybillDAO;

    public Controller(){
        employeeDAO =new EmployeeDAO();
        equipmentDAO = new EquipmentDAO();
        equipmentHistoryDAO = new EquipmentHistoryDAO();
        subdivisionDAO =new SubdivisionDAO();
        repairDAO =new RepairDAO();
        waybillDAO =new WaybillDAO();
    }

    public ObservableList<Employee> getAllEmployee() throws SQLException {
        return employeeDAO.findAllEmployee(); }
    public ObservableList<Equipment> getAllEquipment() throws SQLException {
        return equipmentDAO.findAllEquipment(); }
    public ObservableList<EquipmentHistory> getAllEquipmentHistory() throws SQLException {
        return equipmentHistoryDAO.findAllEquipmentHistory(); }
    public ObservableList<Subdivision> getAllSubdivision() throws SQLException {
        return subdivisionDAO.findAllSubdivision(); }
    public ObservableList<Repairs> getAllRepairs() throws SQLException {
        return repairDAO.findAllRepairs(); }
    public ObservableList<Waybill> getAllWaybills() throws SQLException {
        return waybillDAO.findAllWaybills(); }


    public ObservableList<Employee> getEmployeeByGenderAndAge(String gender,int age) throws SQLException {
        return employeeDAO.findEmployeeByGenderAndAge(gender, age);
    }
    public ObservableList<Employee> getEmployeeBySubdivision(int sub) throws SQLException {
        return employeeDAO.findEmployeeBySubdivision(sub);
    }
    public void addEmployee(int age, String name, int birthYear, String gender, int subdivisionId,
                            String position, Date startDate, Date endDate) throws SQLException {
        employeeDAO.insertIntoDB(age, name, birthYear, gender, subdivisionId, position, startDate, endDate);
    }
    public void updateEmployee(int id, int age,String position,Date date) throws SQLException {
        employeeDAO.updateDB(id, age, position, date);
    }
    public void deleteEmployee(int id) throws SQLException {
        employeeDAO.deleteInDB(id);
    }

    public void addEquipment(String name, String model, int year, int subId, Date date) throws SQLException {
        equipmentDAO.insertIntoTable(name, model, year, subId, date);
    }
    public void updateEquipment(int number, String name ) throws SQLException {
        equipmentDAO.updateTable(number, name);
    }
    public void deleteEquipment(int number) throws SQLException {
        equipmentDAO.deleteInTable(number);
    }
    public Integer getLastEquipmentId() throws SQLException {
        return equipmentDAO.findLastEquipmentId();
    }
    public Integer getCountEquipment(String equipmentName, int subdivision) throws SQLException {
        return  equipmentDAO.findCountEquipmentByNameAndSubdivision(equipmentName, subdivision);
    }
    public void updateEquipmentSub(int id, int subdivision) throws SQLException {
          equipmentDAO.updateSub(id, subdivision);
    }

    public void addEquipmentHistory(Date dateIn,int subdivisionId, int equipmentId) throws SQLException {
        equipmentHistoryDAO.insertIntoTable(dateIn, subdivisionId, equipmentId);
    }
    public void updateEquipmentHistory(Date dateOut,int equipmentId) throws SQLException {
        equipmentHistoryDAO.updateEquipmentHistory(dateOut, equipmentId);
    }

    public void addSubdivision(String name) throws SQLException {
        subdivisionDAO.insertIntoTable(name);
    }
    public void deleteSubdivision(int number) throws SQLException {
        subdivisionDAO.deleteInTable(number);
    }
    public String getSubdivisionWithMaxRepair() throws SQLException {
       return subdivisionDAO.findSubName();
    }

    public void addRepairs(int equipment,Date dateRepairs, String type, int term, String nameTake,
                           int numberTake, String nameGive, int numberGive,String nameFix,
                           int numberFix,String positionFix) throws SQLException {
        repairDAO.insertIntoDB(equipment,dateRepairs, type, term,
                nameTake, numberTake, nameGive, numberGive,
                nameFix, numberFix, positionFix);
    }

    public ObservableList<Waybill> getWaybillByRepair(int repair) throws SQLException {
        return waybillDAO.findByRepair(repair);
    }
    public void addWaybill(int repair, String detail, int cost, Date date) throws SQLException {
        waybillDAO.insertItoDB(repair, detail, cost, date);
    }
}
