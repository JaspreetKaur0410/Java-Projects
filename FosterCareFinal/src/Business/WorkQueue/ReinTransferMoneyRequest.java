/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author jaspr
 */
public class ReinTransferMoneyRequest extends WorkRequest{
    
    String status;
    String Type;
    double amount;
    Date requested;
    Date recieved;
    String docimage;
    Double income;
    String note;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getRequested() {
        return requested;
    }

    public void setRequested(Date requested) {
        this.requested = requested;
    }

    public Date getRecieved() {
        return recieved;
    }

    public void setRecieved(Date recieved) {
        this.recieved = recieved;
    }

    public String getDocimage() {
        return docimage;
    }

    public void setDocimage(String docimage) {
        this.docimage = docimage;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
