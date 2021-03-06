package models;

import java.sql.Date;


public class Repairs {
    private int id;
    private int equipmentId;
    private Date dateRepairs;
    private String type;
    private int term;
    private String nameTake;
    private int numberTake;
    private String nameGive;
    private int numberGive;
    private String nameFix;
    private int numberFix;
    private String positionFix;

    public void setId(int id) { this.id = id;}

    public void setDateRepairs(Date dateRepairs) { this.dateRepairs = dateRepairs; }

    public void setType(String type) { this.type = type; }

    public void setTerm(int term) { this.term = term; }

    public void setNameTake(String nameTake) { this.nameTake = nameTake; }

    public void setNumberTake(int numberTake) { this.numberTake = numberTake; }

    public void setNameGive(String nameGive) { this.nameGive = nameGive; }

    public void setNumberGive(int numberGive) { this.numberGive = numberGive; }

    public void setNameFix(String nameFix) { this.nameFix = nameFix; }

    public void setNumberFix(int numberFix) { this.numberFix = numberFix; }

    public void setPositionFix(String positionFix) { this.positionFix = positionFix; }

    public void setEquipmentId(int equipmentId) { this.equipmentId = equipmentId; }


    public int getId() {
        return id;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public Date getDateRepairs() {
        return dateRepairs;
    }

    public String getType() {
        return type;
    }

    public int getTerm() {
        return term;
    }

    public String getNameTake() {
        return nameTake;
    }

    public int getNumberTake() {
        return numberTake;
    }

    public String getNameGive() {
        return nameGive;
    }

    public int getNumberGive() {
        return numberGive;
    }

    public String getNameFix() {
        return nameFix;
    }

    public int getNumberFix() {
        return numberFix;
    }

    public String getPositionFix() {
        return positionFix;
    }
}
