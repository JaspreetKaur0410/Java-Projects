/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import Business.Enterprise.Agency;
import Business.Organization.Organization;
import Business.Parent.Parent;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
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
    private boolean isSpecialChild;
    Parent parent;
    private boolean isRein;
    private String image;
    private boolean isLabTestDone;
    private boolean isMediacted; 
    
    ArrayList<ChildVitalSigns> vitallist;
    ArrayList<ChildLabTests> labtestlist;
    ArrayList<ChildPrescriptions> prescriptionslist;

    private static int count = 0;
    
    private boolean isVitalSignNormal;
    private boolean isLabTestNormal;

    public Child(){
        count++;
        CaseNo = count;
        vitallist = new ArrayList<>();
        labtestlist = new ArrayList<>();
        prescriptionslist = new ArrayList<>();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCaseNo() {
        return CaseNo;
    }

    public boolean isIsLabTestDone() {
        return isLabTestDone;
    }

    public void setIsLabTestDone(boolean isLabTestDone) {
        this.isLabTestDone = isLabTestDone;
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

    public boolean isIsMediacted() {
        return isMediacted;
    }

    public void setIsMediacted(boolean isMediacted) {
        this.isMediacted = isMediacted;
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

   
    public boolean isIsVitalSignNormal() {
        return isVitalSignNormal;
    }

    public void setIsVitalSignNormal(boolean isVitalSignNormal) {
        this.isVitalSignNormal = isVitalSignNormal;
    }

    public ArrayList<ChildVitalSigns> getVitallist() {
        return vitallist;
    }

    public void setVitallist(ArrayList<ChildVitalSigns> vitallist) {
        this.vitallist = vitallist;
    }
    
    
    
    public ChildVitalSigns addVitalSign(){
        ChildVitalSigns childvitalsign = new ChildVitalSigns();
        if(vitallist == null){
            vitallist = new ArrayList<>();
            vitallist.add(childvitalsign);
        }
        else{
            vitallist.add(childvitalsign);
        }
        return childvitalsign;
    }

    public ArrayList<ChildLabTests> getLabtestlist() {
        return labtestlist;
    }

    public void setLabtestlist(ArrayList<ChildLabTests> labtestlist) {
        this.labtestlist = labtestlist;
    }

    public boolean isIsLabTestNormal() {
        return isLabTestNormal;
    }

    public void setIsLabTestNormal(boolean isLabTestNormal) {
        this.isLabTestNormal = isLabTestNormal;
    }

    public ChildLabTests addChildLabTest(){
        ChildLabTests childlabtest = new ChildLabTests();
        if(labtestlist == null){
            labtestlist = new ArrayList<>();
            labtestlist.add(childlabtest);
        }
        else{
            labtestlist.add(childlabtest);
        }
        return childlabtest;
    }

    public ArrayList<ChildPrescriptions> getPrescriptionslist() {
        if(prescriptionslist == null){
            prescriptionslist = new ArrayList<>();
        }
        return prescriptionslist;
    }

    public void setPrescriptionslist(ArrayList<ChildPrescriptions> prescriptionslist) {
        this.prescriptionslist = prescriptionslist;
    }
    
    public ChildPrescriptions addChildPrescriptions(){
        ChildPrescriptions childprescription = new ChildPrescriptions();
        if(childprescription == null){
            prescriptionslist = new ArrayList<>();
            prescriptionslist.add(childprescription);
        }
        else{
            prescriptionslist.add(childprescription);
        }
        return childprescription;
    }

    public boolean isIsSpecialChild() {
        return isSpecialChild;
    }

    public void setIsSpecialChild(boolean isSpecialChild) {
        this.isSpecialChild = isSpecialChild;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public boolean isIsRein() {
        return isRein;
    }

    public void setIsRein(boolean isRein) {
        this.isRein = isRein;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
 
}
