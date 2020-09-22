package models;
import java.util.GregorianCalendar;
/*
показывает в каком подразделении находилась указываемая техника
в определенный момент времени
 */

public class EquipmentInSubdivision {
    private int subdivisionId;
    private int equipmentId;
    private GregorianCalendar dateIn;
    private GregorianCalendar dateOut;

    public EquipmentInSubdivision(int subdivisionId, int equipmentId, GregorianCalendar dateIn, GregorianCalendar dateOut) {
        this.subdivisionId = subdivisionId;
        this.equipmentId = equipmentId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }
}
