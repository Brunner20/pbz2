package models;

import java.util.GregorianCalendar;

public class TransferDoc {
    private int equipmentId;
    private int subdivisionId;
    private GregorianCalendar transferDate;

    public TransferDoc(int equipmentId, int subdivisionId, GregorianCalendar transferDate) {
        this.equipmentId = equipmentId;
        this.subdivisionId = subdivisionId;
        this.transferDate = transferDate;
    }
}
