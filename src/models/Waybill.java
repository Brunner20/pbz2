package models;

import java.util.GregorianCalendar;

public class Waybill {
    private int repairsId;
    private int equipmentNumber;
    private int cost;
    private GregorianCalendar dateIn;

    public Waybill(int repairsId, int equipmentNumber, int cost, GregorianCalendar dateIn) {
        this.repairsId = repairsId;
        this.equipmentNumber = equipmentNumber;
        this.cost = cost;
        this.dateIn = dateIn;
    }



}
