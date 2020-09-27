package models;

import java.sql.Date;


public class Repairs {
    private int id;
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
    private int waybillId;

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

    public void setWaybillId(int waybillId) { this.waybillId = waybillId; }
}
