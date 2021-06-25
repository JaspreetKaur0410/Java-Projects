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
public class House {
    
    

    /*private int id;
    private String streetname;
    private String city;
    private String state;
    private int zipcode;
    
    private static int count = 0;
    
    public House(){
        count++;
        id = count;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
    
    public void addCity(){
        
    }*/
    
    private int houseid;
    private String streetname;
    private ArrayList<Person> personlist;
    private ArrayList<Patient> patientlist;
    
    private static int count = 0;
    
    public House(){
        count++;
        houseid = count;
        
        personlist = new ArrayList<>();
        patientlist = new ArrayList<>();
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    @Override
    public String toString() {
        return streetname;
    }
    
    public Person addPerson(){
        Person p = new Person();
        personlist.add(p);
        return p;
    }

    public ArrayList<Person> getPersonlist() {
        return personlist;
    }

    public void setPersonlist(ArrayList<Person> personlist) {
        this.personlist = personlist;
    }

    public ArrayList<Patient> getPatientlist() {
        return patientlist;
    }

    public void setPatientlist(ArrayList<Patient> patientlist) {
        this.patientlist = patientlist;
    }

    

    public Patient addPatient(){
        
        Patient p = new Patient();
        patientlist.add(p);
        return p;
    }
    
    public void removePerson(Person p,Community comm){
        personlist.remove(p);
        
    }
    
   public Person updatePerson(Person p){
       for(Person per:personlist){
           if(String.valueOf(per.getId()).equals(String.valueOf(p.getId()))){
               return per;
           }
       }
       return null;
   }
}
