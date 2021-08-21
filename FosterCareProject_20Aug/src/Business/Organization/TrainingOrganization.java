/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FosterAdminRole;
import Business.Role.Role;
import Business.Role.TrainerRole;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class TrainingOrganization extends Organization{
    
    String name;
    public TrainingOrganization(String name) {
        super(name);
        this.name = name;
    }
    
    public TrainingOrganization() {
        super(Type.TrainingOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new TrainerRole());
        return roles;
    }  
}
