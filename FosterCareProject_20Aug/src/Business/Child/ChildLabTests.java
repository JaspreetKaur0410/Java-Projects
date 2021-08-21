/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author jaspr
 */
public class ChildLabTests implements Comparable<ChildLabTests> {
    
    private double haemoglobin;
    private double glucose;
    private int bloodcount;
    private double cholestrol;
    private double hdl;
    private double ldl;
    
    private int Dopamine;
    private double metanephrine;
    
    private boolean ishaemoglobinNormal;
    private boolean isglucosenormal;
    private boolean isbloodcountnormal;
    private boolean ischolnormal;
    private boolean ishdlnormal;
    private boolean isldlnormal;
    private boolean isdopaminenormal;
    private boolean ismetnormal;
    
    private boolean isBloodTestNormal;
    private boolean isUrineTestNormal;
    
    private Date labtestdate;
    
    private boolean is_bloodTestRequired;
    private boolean is_urineTestRequired;

    public double getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(double haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public double getGlucose() {
        return glucose;
    }

    public void setGlucose(double glucose) {
        this.glucose = glucose;
    }

    public int getBloodcount() {
        return bloodcount;
    }

    public void setBloodcount(int bloodcount) {
        this.bloodcount = bloodcount;
    }

    public double getCholestrol() {
        return cholestrol;
    }

    public void setCholestrol(double cholestrol) {
        this.cholestrol = cholestrol;
    }

    public double getHdl() {
        return hdl;
    }

    public void setHdl(double hdl) {
        this.hdl = hdl;
    }

    public double getLdl() {
        return ldl;
    }

    public void setLdl(double ldl) {
        this.ldl = ldl;
    }

    public int getDopamine() {
        return Dopamine;
    }

    public void setDopamine(int Dopamine) {
        this.Dopamine = Dopamine;
    }

    public double getMetanephrine() {
        return metanephrine;
    }

    public void setMetanephrine(double metanephrine) {
        this.metanephrine = metanephrine;
    }

    public boolean isIsBloodTestNormal() {
        return isBloodTestNormal;
    }

    public void setIsBloodTestNormal(boolean isBloodTestNormal) {
        this.isBloodTestNormal = isBloodTestNormal;
    }

    public boolean isIsUrineTestNormal() {
        return isUrineTestNormal;
    }

    public void setIsUrineTestNormal(boolean isUrineTestNormal) {
        this.isUrineTestNormal = isUrineTestNormal;
    }

    public Date getLabtestdate() {
        return labtestdate;
    }

    public void setLabtestdate(Date labtestdate) {
        this.labtestdate = labtestdate;
    }

    public boolean isIshaemoglobinNormal() {
        return ishaemoglobinNormal;
    }

    public void setIshaemoglobinNormal(boolean ishaemoglobinNormal) {
        this.ishaemoglobinNormal = ishaemoglobinNormal;
    }

    public boolean isIsglucosenormal() {
        return isglucosenormal;
    }

    public void setIsglucosenormal(boolean isglucosenormal) {
        this.isglucosenormal = isglucosenormal;
    }

    public boolean isIsbloodcountnormal() {
        return isbloodcountnormal;
    }

    public void setIsbloodcountnormal(boolean isbloodcountnormal) {
        this.isbloodcountnormal = isbloodcountnormal;
    }

    public boolean isIscholnormal() {
        return ischolnormal;
    }

    public void setIscholnormal(boolean ischolnormal) {
        this.ischolnormal = ischolnormal;
    }

    public boolean isIshdlnormal() {
        return ishdlnormal;
    }

    public void setIshdlnormal(boolean ishdlnormal) {
        this.ishdlnormal = ishdlnormal;
    }

    public boolean isIsldlnormal() {
        return isldlnormal;
    }

    public void setIsldlnormal(boolean isldlnormal) {
        this.isldlnormal = isldlnormal;
    }

    public boolean isIsdopaminenormal() {
        return isdopaminenormal;
    }

    public void setIsdopaminenormal(boolean isdopaminenormal) {
        this.isdopaminenormal = isdopaminenormal;
    }

    public boolean isIsmetnormal() {
        return ismetnormal;
    }

    public void setIsmetnormal(boolean ismetnormal) {
        this.ismetnormal = ismetnormal;
    }

    public boolean isIs_bloodTestRequired() {
        return is_bloodTestRequired;
    }

    public void setIs_bloodTestRequired(boolean is_bloodTestRequired) {
        this.is_bloodTestRequired = is_bloodTestRequired;
    }

    public boolean isIs_urineTestRequired() {
        return is_urineTestRequired;
    }

    public void setIs_urineTestRequired(boolean is_urineTestRequired) {
        this.is_urineTestRequired = is_urineTestRequired;
    }

    @Override
    public String toString() {
        return String.valueOf(labtestdate);
    }

    @Override
    public int compareTo(ChildLabTests o) {
        
        if(o.getLabtestdate().after(this.labtestdate)){
            return -1;
        }
        else if(o.getLabtestdate().before(this.labtestdate)){
            return 1;
        }
        else{
            return 0;
        }

    }
}
