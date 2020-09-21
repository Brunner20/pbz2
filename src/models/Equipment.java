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
}
