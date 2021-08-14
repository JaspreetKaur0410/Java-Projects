/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Child.ChildDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.Parent.ParentDirectory;
//import Business.Role.Role;
import java.util.ArrayList;



/**
 *
 * @author MyPC1
 */

public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private EnterpriseDirectory enterpriseDirectory;
    private OrganizationDirectory organizationDirectory;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    private ParentDirectory parentDirectory;
    private ChildDirectory childdirectory;
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }

   public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }

    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    
    
    
    public boolean checkIfUserIsUnique(String userName){
        if(this.business!=null){
           for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    if (ua.getUsername().equalsIgnoreCase(userName)) {
                        return false;
                    }
                }
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getUsername().equalsIgnoreCase(userName)) {
                            return false;
                        }
                    }
                }
            }
        }

       }
        
        return true;
    }
    
    public static void setInstance(EcoSystem system) {
        business = system;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        if(enterpriseDirectory == null){
            enterpriseDirectory = new EnterpriseDirectory();
        }
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
         if(userAccountDirectory == null){
            userAccountDirectory = new UserAccountDirectory();
        }
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        if(employeeDirectory == null){
            employeeDirectory = new EmployeeDirectory();
        }
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        if(organizationDirectory == null){
            organizationDirectory = new OrganizationDirectory();
        }
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public static EcoSystem getBusiness() {
        if(business == null){
            business = new EcoSystem();
        }
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }
    
     public boolean isUnique(String name){
        for(Network network : networkList){
            if(network.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }

    public ParentDirectory getParentDirectory() {
        if(parentDirectory == null){
            parentDirectory = new ParentDirectory();
        }
        return parentDirectory;
    }

    public void setParentDirectory(ParentDirectory parentDirectory) {
        
        this.parentDirectory = parentDirectory;
    }

    public ChildDirectory getChilddirectory() {
        if(childdirectory == null){
            childdirectory = new ChildDirectory();
        }
        return childdirectory;
    }

    public void setChilddirectory(ChildDirectory childdirectory) {
        this.childdirectory = childdirectory;
    }
     
    
    
    
   
}
