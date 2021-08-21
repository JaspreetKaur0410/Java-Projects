/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PharmacistRole;
import Business.Role.ReinbursementsManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class ReinbursementsOrganisation extends Organization{
    
    String name;
    public ReinbursementsOrganisation(String name) {
        super(name);
        this.name = name;
    }
    
    public ReinbursementsOrganisation() {
        super(Type.ReinbursementsOrganisation.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new ReinbursementsManager());
        return roles;
    }  
    
}
