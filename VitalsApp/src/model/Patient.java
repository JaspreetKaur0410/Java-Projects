/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class Patient extends Person {
 
    ArrayList<VitalSign> vitallist;
    Patient patient;
    ArrayList<Encounter> encounterhistory;
   
    
    public Patient(){
        vitallist = new ArrayList<>();
        encounterhistory = new ArrayList<>();
    }

   

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    
    public VitalSign addVital(){
        VitalSign vs = new VitalSign();
        vitallist.add(vs);
        return vs;
    }
    
    public ArrayList<Encounter> getEncounterhistory() {
        return encounterhistory;
    }

    public void setEncounterhistory(ArrayList<Encounter> encounterhistory) {
        this.encounterhistory = encounterhistory;
    }
    
   public Encounter addencounter(){
        Encounter encounter = new Encounter();
        encounterhistory.add(encounter);
        return encounter;
    }

}
