/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import Business.Enterprise.Agency;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author jaspr
 */
public class Child extends UserAccount{
    
    private int CaseNo;
    private String firstname;
    private String lastname;
    private String gender;
    private int age;
    private String city;
    private String race;
    private String religion;
    private Organization org;
    private ImageIcon imageicon;
    private String about_child;
    private Date last_profileupdated;
    boolean isAdopted;
    private String medicalStatus;
    private boolean medicalHelp;
    
    private int BP;
    private int pulseRate;
    private int respirationRate;
    private double bodytemp;
    private double weight;
    
    private Date VitalSignsDate;
    
    private boolean isVitalSignsNormal;
   
    private static int count = 0;
    
    public Child(){
        count++;
        CaseNo = count;
    }

    public int getCaseNo() {
        return CaseNo;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

   

    public ImageIcon getImageicon() {
        return imageicon;
    }

    public void setImageicon(ImageIcon imageicon) {
        this.imageicon = imageicon;
    }

    public String getAbout_child() {
        return about_child;
    }

    public void setAbout_child(String about_child) {
        this.about_child = about_child;
    }

    public Date getLast_profileupdated() {
        return last_profileupdated;
    }

    public void setLast_profileupdated(Date last_profileupdated) {
        this.last_profileupdated = last_profileupdated;
    }

   

    public void setCaseNo(int CaseNo) {
        this.CaseNo = CaseNo;
    }

    public boolean isIsAdopted() {
        return isAdopted;
    }

    public void setIsAdopted(boolean isAdopted) {
        this.isAdopted = isAdopted;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }

    public boolean isMedicalHelp() {
        return medicalHelp;
    }

    public void setMedicalHelp(boolean medicalHelp) {
        this.medicalHelp = medicalHelp;
    }

    public int getBP() {
        return BP;
    }

    public void setBP(int BP) {
        this.BP = BP;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public int getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(int respirationRate) {
        this.respirationRate = respirationRate;
    }

    public double getBodytemp() {
        return bodytemp;
    }

    public void setBodytemp(double bodytemp) {
        this.bodytemp = bodytemp;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getVitalSignsDate() {
        return VitalSignsDate;
    }

    public void setVitalSignsDate(Date VitalSignsDate) {
        this.VitalSignsDate = VitalSignsDate;
    }

    public boolean isIsVitalSignsNormal() {
        return isVitalSignsNormal;
    }

    public void setIsVitalSignsNormal(boolean isVitalSignsNormal) {
        this.isVitalSignsNormal = isVitalSignsNormal;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
 
}
