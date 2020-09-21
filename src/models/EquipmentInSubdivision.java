package models;

import sun.java2d.loops.GeneralRenderer;

import java.util.GregorianCalendar;

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
