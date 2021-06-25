/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jaspr
 */
public class City {
    
    String name;
    int cityid;
    
    Community community;
    
    ArrayList<City> citylist;
    ArrayList<Community> communitylist;
    private ArrayList<Patient> patientlist;
    
    private static int count = -1;
    
    public City(){
        count++;
        cityid = count;
        
        citylist = new ArrayList<>();
        communitylist = new ArrayList<>();
        patientlist = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getCitylist() {
       
            return citylist;
        
    }

    public void setCitylist(ArrayList<City> citylist) {
        this.citylist = citylist;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }
    
    
    
    public City addCity(){
        City c = new City();
        citylist.add(c);
        return c;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public ArrayList<Community> getCommunitylist() {
        return communitylist;
    }

    public void setCommunitylist(ArrayList<Community> communitylist) {
        this.communitylist = communitylist;
    }
    
     public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
    
     public Community addcommunity(){
        Community comm = new Community();
        communitylist.add(comm);
        return comm;
    }
     
    public ArrayList<Patient> getPatientlist() {
        return patientlist;
    }

    public void setPatientlist(ArrayList<Patient> patientlist) {
        this.patientlist = patientlist;
    }
    
    public void removeCity(City c){
        citylist.remove(c);
    }
    
    public void removeCommunity(Community c){
        communitylist.remove(c);
    }
    
}

