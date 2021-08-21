/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FosterAdminRole;
import Business.Role.PharmacistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class PharmaOrganisation extends Organization{
    
    String name;
    public PharmaOrganisation(String name) {
        super(name);
        this.name = name;
    }
    
    public PharmaOrganisation() {
        super(Type.PharmaOrganisation.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new PharmacistRole());
        return roles;
    }  
}
