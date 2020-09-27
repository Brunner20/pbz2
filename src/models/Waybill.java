package models;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Waybill {
    private int id;
    private int equipmentNumber;
    private int cost;
    private Date receivingDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setEquipmentNumber(int equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }
}
