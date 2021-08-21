/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import java.util.Date;

/**
 *
 * @author jaspr
 */
public class ChildPrescriptions {
    
    private String prescription;
    private Date prescriptiondate;
    private boolean isMedicated;

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Date getPrescriptiondate() {
        return prescriptiondate;
    }

    public void setPrescriptiondate(Date prescriptiondate) {
        this.prescriptiondate = prescriptiondate;
    }

    public boolean isIsMedicated() {
        return isMedicated;
    }

    public void setIsMedicated(boolean isMedicated) {
        this.isMedicated = isMedicated;
    }

}
