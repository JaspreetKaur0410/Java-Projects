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
public class EncounterHistory {
    
    ArrayList<Encounter> encounterhistory;
    
    public EncounterHistory(){
        encounterhistory = new ArrayList<>();
    }

    public ArrayList<Encounter> getEncounterhistory() {
        return encounterhistory;
    }

    public void setEncounterhistory(ArrayList<Encounter> encounterhistory) {
        this.encounterhistory = encounterhistory;
    }
    
    
    
}
