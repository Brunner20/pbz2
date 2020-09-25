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
}
