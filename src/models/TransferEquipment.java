package models;

import java.util.GregorianCalendar;

public class TransferEquipment {
    private int equipmentId;
    private int subdivisionId;
    private GregorianCalendar transferDate;

    public TransferEquipment(int equipmentId, int subdivisionId, GregorianCalendar transferDate) {
        this.equipmentId = equipmentId;
        this.subdivisionId = subdivisionId;
        this.transferDate = transferDate;
    }
}
