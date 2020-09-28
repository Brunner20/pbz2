package models;

import java.sql.Date;

public class Waybill {
    private int id;
    private int repairNumber;
    private String detail;
    private int cost;
    private Date receivingDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setRepairNumber(int repairNumber) {
        this.repairNumber = repairNumber;
    }

    public void setDetail(String detail) { this.detail = detail; }

    public void setCost(int cost) { this.cost = cost; }

    public void setReceivingDate(Date receivingDate) { this.receivingDate = receivingDate;}

    public int getId() {
        return id;
    }

    public int getRepairNumber() {
        return repairNumber;
    }

    public String getDetail() {
        return detail;
    }

    public int getCost() {
        return cost;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }
}
