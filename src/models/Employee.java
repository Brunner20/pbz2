package models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Employee {
    private int id ;
    private int age;
    private String name;
    private int birthYear;
    private String gender;
    private int subdivisionId;
    private String position;
    private Date startDate;
    private Date endDate;

    public Employee(int age, String name, int birthYear, String gender, int subdivisionId,
                    String position, Date startDate, Date endDate) throws NumberFormatException{
        this.id ++;
        this.age = age;
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.subdivisionId = subdivisionId;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Employee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age)  { this.age = age; }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSubdivisionId(int subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getId() { return id; }
    public int getAge() { return age; }

    public String getName() { return name; }

    public int getBirthYear() { return birthYear; }

    public String getGender()  { return gender; }

    public int getSubdivisionId() { return subdivisionId; }

    public String getPosition() { return position; }

    public Date getStartDate() { return startDate; }

    public Date getEndDate() { return endDate; }
}
