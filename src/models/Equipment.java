package models;

import java.sql.Date;

public class Equipment {
    private int number;
    private String name;
    private String model;
    private int yearIssue;
    private int subdivisionId;
    private Date dateIn;



    public Equipment(){}

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearIssue(int yearIssue) {
        this.yearIssue = yearIssue;
    }

    public void setSubdivisionId(int subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public void setDateIn(Date dateIn) { this.dateIn = dateIn; }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getNumber() {
        return number;
    }

    public int getYearIssue() {
        return yearIssue;
    }

    public int getSubdivisionId() {
        return subdivisionId;
    }

    public Date getDateIn() {
        return dateIn;
    }
}
