package models;

import java.util.GregorianCalendar;

public class Waybill {
    private int repairsId;
    private int equipmentNumber;
    private int cost;
    private GregorianCalendar receivingDate;

    public Waybill(int repairsId, int equipmentNumber, int cost, GregorianCalendar receivingDate) {
        this.repairsId = repairsId;
        this.equipmentNumber = equipmentNumber;
        this.cost = cost;
        this.receivingDate = receivingDate;
    }



}
