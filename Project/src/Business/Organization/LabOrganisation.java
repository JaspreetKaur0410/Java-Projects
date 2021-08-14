/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.LabortaryAssistant;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class LabOrganisation extends Organization{
    
    String name;
    public LabOrganisation(String name) {
        super(name);
        this.name = name;
    }
    
    public LabOrganisation() {
        super(Type.DoctorOrganisation.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new LabortaryAssistant());
        return roles;
    }
    
}
