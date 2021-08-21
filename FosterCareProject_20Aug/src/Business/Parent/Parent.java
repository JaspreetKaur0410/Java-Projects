/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Parent;

import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author jaspr
 */
public class Parent extends UserAccount{
    
    private UserAccountDirectory userAccountDirectory;
    
    private static int parentid;
    private String firstname;
    private String lastname;
    private int phone;
    private String email;
    private String gender;
    private String relation_status;
    private String race;
    private String religion;
    private String occupation;
    private Double income;
    
    private String s_firstname;
    private String s_lastname;
    private int s_phone;
    private String s_email;
    private String s_gender;
    private String s_relation_status;
    private String s_race;
    private String s_religion;
    private String s_occupation;
    private Double s_income;
    
    //ChildPreferences
    
    private int preference_child_age;
    private String preference_child_gender;
    private String preference_child_race;
    private String preference_child_religion;
    private String preference_child_healthstatus;
    private String preference_child_handicapacceptance;
    
    // ADDRESS INFORMATION
    private String home_address;
    private String State;
    private String City;
    private String isPet;
    private int number_of_family_memebers;
    private String type_rein;
    
    private boolean flag;
    private boolean isRein;
    
    public UserAccountDirectory getUserAccountDirectory() {
        if(userAccountDirectory == null){
            userAccountDirectory = new UserAccountDirectory();
        }
        return userAccountDirectory;
    }

    
    public Parent(){
        parentid++;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelation_status() {
        return relation_status;
    }

    public void setRelation_status(String relation_status) {
        this.relation_status = relation_status;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getS_firstname() {
        return s_firstname;
    }

    public void setS_firstname(String s_firstname) {
        this.s_firstname = s_firstname;
    }

    public String getS_lastname() {
        return s_lastname;
    }

    public void setS_lastname(String s_lastname) {
        this.s_lastname = s_lastname;
    }

    public int getS_phone() {
        return s_phone;
    }

    public void setS_phone(int s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_gender() {
        return s_gender;
    }

    public void setS_gender(String s_gender) {
        this.s_gender = s_gender;
    }

    public String getS_relation_status() {
        return s_relation_status;
    }

    public void setS_relation_status(String s_relation_status) {
        this.s_relation_status = s_relation_status;
    }

    public String getS_race() {
        return s_race;
    }

    public void setS_race(String s_race) {
        this.s_race = s_race;
    }

    public String getS_religion() {
        return s_religion;
    }

    public void setS_religion(String s_religion) {
        this.s_religion = s_religion;
    }

    public String getS_occupation() {
        return s_occupation;
    }

    public void setS_occupation(String s_occupation) {
        this.s_occupation = s_occupation;
    }

    public Double getS_income() {
        return s_income;
    }

    public void setS_income(Double s_income) {
        this.s_income = s_income;
    }

    public int getPreference_child_age() {
        return preference_child_age;
    }

    public void setPreference_child_age(int preference_child_age) {
        this.preference_child_age = preference_child_age;
    }

    public String getPreference_child_gender() {
        return preference_child_gender;
    }

    public void setPreference_child_gender(String preference_child_gender) {
        this.preference_child_gender = preference_child_gender;
    }

    public String getPreference_child_race() {
        return preference_child_race;
    }

    public void setPreference_child_race(String preference_child_race) {
        this.preference_child_race = preference_child_race;
    }

    public String getPreference_child_religion() {
        return preference_child_religion;
    }

    public void setPreference_child_religion(String preference_child_religion) {
        this.preference_child_religion = preference_child_religion;
    }

    public String getPreference_child_healthstatus() {
        return preference_child_healthstatus;
    }

    public void setPreference_child_healthstatus(String preference_child_healthstatus) {
        this.preference_child_healthstatus = preference_child_healthstatus;
    }

    public String getPreference_child_handicapacceptance() {
        return preference_child_handicapacceptance;
    }

    public void setPreference_child_handicapacceptance(String preference_child_handicapacceptance) {
        this.preference_child_handicapacceptance = preference_child_handicapacceptance;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getIsPet() {
        return isPet;
    }

    public void setIsPet(String isPet) {
        this.isPet = isPet;
    }

    public int getNumber_of_family_memebers() {
        return number_of_family_memebers;
    }

    public void setNumber_of_family_memebers(int number_of_family_memebers) {
        this.number_of_family_memebers = number_of_family_memebers;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isIsRein() {
        return isRein;
    }

    public void setIsRein(boolean isRein) {
        this.isRein = isRein;
    }

    public String getType_rein() {
        return type_rein;
    }

    public void setType_rein(String type_rein) {
        this.type_rein = type_rein;
    }

    @Override
    public String toString() {
        return firstname + " " +lastname;
    }
 
    
}
