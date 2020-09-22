package models;

public class Equipment {
    private int number;
    private String name;
    private String model;
    private int yearIssue;
    private int subdivisionId;

    public Equipment(int number, String name, String model, int yearIssue, int subdivisionId) {
        this.number = number;
        this.name = name;
        this.model = model;
        this.yearIssue = yearIssue;
        this.subdivisionId = subdivisionId;
    }

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
}
