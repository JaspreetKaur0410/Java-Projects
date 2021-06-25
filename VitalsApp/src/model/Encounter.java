/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jaspr
 */
public class Encounter {
    
    private int doctorid;
    private String doctorname;
    Date date;
    Patient patient;
    String vitalsign;
    int vitalval;
   String status;
    
    public Encounter(){
        
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }
    
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public String getVitalsign() {
        return vitalsign;
    }

    public void setVitalsign(String vitalsign) {
        this.vitalsign = vitalsign;
    }

    public int getVitalval() {
        return vitalval;
    }

    public void setVitalval(int vitalval) {
        this.vitalval = vitalval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
   
    
}
