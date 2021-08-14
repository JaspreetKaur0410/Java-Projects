/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;

/**
 *
 * @author jaspr
 */
public class MedicalCheckRequest extends WorkRequest {
    
    private String testResult;
    private String prescription;
    private String remark;
    private Organization senderOrganisation;
    private Enterprise senderEnterprise;
    
    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Organization getSenderOrganisation() {
        return senderOrganisation;
    }

    public void setSenderOrganisation(Organization senderOrganisation) {
        this.senderOrganisation = senderOrganisation;
    }

    public Enterprise getSenderEnterprise() {
        return senderEnterprise;
    }

    public void setSenderEnterprise(Enterprise senderEnterprise) {
        this.senderEnterprise = senderEnterprise;
    }
    
    
    
}
