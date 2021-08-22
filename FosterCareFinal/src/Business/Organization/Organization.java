/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Employee.EmployeeDirectory;
//import Business.Role.Role;
//import Business.UserAccount.UserAccountDirectory;
//import Business.WorkQueue.WorkQueue;
import Business.Child.ChildDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Jaspreet Kaur
 */
public abstract class Organization {

    private String name;
    //private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    private Type type;
    
    private WorkQueue workQueue;
    
    ChildDirectory childDirectory;
    
    public Organization(){
        
    }
    
    public enum Type{
        AdminOrganization("AdminOrganization"),
        FosterOrganization("FosterOrganization"),
        //Find_A_MatchOrganization("Find_A_MatchOrganization"),
        TrainingOrganization("TrainingOrganization"),
        BackgroundCheckOrganisation("BackgroundCheckOrganisation"),
        DoctorOrganisation("DoctorOrganisation"),
        LabOrganisation("LabOrganisation"),
        PharmaOrganisation("PharmaOrganisation"),
        ReinbursementsOrganisation("ReinbursementsOrganisation"),
        ReinbursementsFinanaceOrganisation("ReinbursementsFinanaceOrganisation"),
        CulturalEventOrganisation("CulturalEventOrganisation"),
        CulturalEventOrganiser("CulturalEventOrganiser");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        //workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        if(userAccountDirectory == null){
            userAccountDirectory = new UserAccountDirectory();
        }
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        if(employeeDirectory == null){
            employeeDirectory = new EmployeeDirectory();
        }
        return employeeDirectory;
    }
   
    public String getName() {
        return name;
    }

    /*public WorkQueue getWorkQueue() {
        return workQueue;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    /*public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }*/

    @Override
    public String toString() {
        return name;
    }
    
     public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ChildDirectory getChildDirectory() {
        if(childDirectory == null){
            childDirectory = new ChildDirectory();
        }
        return childDirectory;
    }

    public void setChildDirectory(ChildDirectory childDirectory) {
        this.childDirectory = childDirectory;
    }

    public WorkQueue getWorkQueue() {
        if(workQueue == null){
            workQueue = new WorkQueue();
        }
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

}
