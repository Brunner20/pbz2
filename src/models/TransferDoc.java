package models;

import java.sql.Date;;


public class TransferDoc {
    private int equipmentId;
    private int subdivisionId;
    private Date transferDate;

    public TransferDoc(int equipmentId, int subdivisionId, Date transferDate) {
        this.equipmentId = equipmentId;
        this.subdivisionId = subdivisionId;
        this.transferDate = transferDate;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public int getSubdivisionId() {
        return subdivisionId;
    }

    public Date getTransferDate() {
        return transferDate;
    }
}
