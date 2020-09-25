package models;
import java.sql.Date;

/*
показывает в каком подразделении находилась указываемая техника
в определенный момент времени
 */

public class EquipmentHistory {
    private int id;
    private int subdivisionId;
    private int equipmentId;
    private Date dateIn;
    private Date dateOut;

    public EquipmentHistory() {

    }

    public void setId(int id) { this.id = id; }

    public void setSubdivisionId(int subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
}
