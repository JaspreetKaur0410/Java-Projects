/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Child.ChildDirectory;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    
 
    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        /*if(organizationList.isEmpty()){
            organizationList = new ArrayList();
        }*/
        return organizationList;
    }
    
    public Organization createOrganization(String name,Type type){
       Organization organization = null;
        System.out.println(type.getValue());
       if (type.getValue().equals(Type.FosterOrganization.getValue().toString())){
            organization = new FosterOrganization(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.BackgroundCheckOrganisation.getValue().toString())){
            organization = new BackgroundCheckOrganisation(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.TrainingOrganization.getValue().toString())){
            organization = new TrainingOrganization(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.DoctorOrganisation.getValue().toString())){
            organization = new DoctorOrganisation(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.LabOrganisation.getValue().toString())){
            organization = new LabOrganisation(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.PharmaOrganisation.getValue().toString())){
            organization = new PharmaOrganisation(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.ReinbursementsOrganisation.getValue().toString())){
            organization = new ReinbursementsOrganisation(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.ReinbursementsFinanaceOrganisation.getValue().toString())){
            organization = new ReinbursementsFinanaceOrganisation(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.CulturalEventOrganisation.getValue().toString())){
            organization = new CulturalEventOrganisation(name);
            organization.setType(type);
            organizationList.add(organization);
        }
       if (type.getValue().equals(Type.CulturalEventOrganiser.getValue().toString())){
            organization = new CulturalEventOrganiser(name);
            organization.setType(type);
            organizationList.add(organization);
        }
      
       return organization;
    }
    
    public boolean isUnique(String name){
        
        for(Organization organization : organizationList){
            if(name.equalsIgnoreCase(organization.getName())){
                return false;
            }
        }
        
        return true;
    }
    
   

   

}