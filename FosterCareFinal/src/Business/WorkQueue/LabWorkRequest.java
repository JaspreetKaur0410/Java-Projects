/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Organization.Organization;

/**
 *
 * @author jaspr
 */
public class LabWorkRequest extends WorkRequest{
    
    private boolean is_blood_test_required;
    private boolean is_urine_test_required;
    private String blood_test_result;
    private String urine_test_result;
    private boolean isLabDone;
    //private Organization senderorg;

    public boolean isIs_blood_test_required() {
        return is_blood_test_required;
    }

    public void setIs_blood_test_required(boolean is_blood_test_required) {
        this.is_blood_test_required = is_blood_test_required;
    }

    public boolean isIs_urine_test_required() {
        return is_urine_test_required;
    }

    public boolean isIsLabDone() {
        return isLabDone;
    }

    public void setIsLabDone(boolean isLabDone) {
        this.isLabDone = isLabDone;
    }

    public void setIs_urine_test_required(boolean is_urine_test_required) {
        this.is_urine_test_required = is_urine_test_required;
    }

    

    public String getBlood_test_result() {
        return blood_test_result;
    }

    public void setBlood_test_result(String blood_test_result) {
        this.blood_test_result = blood_test_result;
    }

    public String getUrine_test_result() {
        return urine_test_result;
    }

    public void setUrine_test_result(String urine_test_result) {
        this.urine_test_result = urine_test_result;
    }
    
}
