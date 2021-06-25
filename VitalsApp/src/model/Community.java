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
public class Community {
    
    String name;
    int id;
    City city;
    
    private ArrayList<House> houselist;
     private ArrayList<Patient> patientlist;
    
    private static int count = -1;
    
    public Community(){
        count++;
        id = count;
        
        houselist = new ArrayList<>();
        patientlist = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public String toString() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<House> getHouselist() {
        return houselist;
    }

    public void setHouselist(ArrayList<House> houselist) {
        this.houselist = houselist;
    }
    
    public House addHouse(){
       House h = new House(); 
       houselist.add(h);
       return h;
    }

    public ArrayList<Patient> getPatientlist() {
        return patientlist;
    }

    public void setPatientlist(ArrayList<Patient> patientlist) {
        this.patientlist = patientlist;
    }
    
    public void removeHouse(House h){
        houselist.remove(h);
    }
  
    
    
}
