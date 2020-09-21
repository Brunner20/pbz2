package models;

import java.util.GregorianCalendar;

public class Employee {
    private int id;
    private int age;
    private String name;
    private int birthYear;
    private String sex;
    private int subdivisionId;
    private String position;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;

    public Employee(int id, int age, String name, int birthYear, String sex, int subdivisionId,
                    String position, GregorianCalendar startDate, GregorianCalendar endDate) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.birthYear = birthYear;
        this.sex = sex;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSubdivisionId(int subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }
}
