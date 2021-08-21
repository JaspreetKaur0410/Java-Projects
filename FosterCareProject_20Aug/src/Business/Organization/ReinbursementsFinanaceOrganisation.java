/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PharmacistRole;
import Business.Role.ReinAccountant;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class ReinbursementsFinanaceOrganisation extends Organization{
    
    String name;
    public ReinbursementsFinanaceOrganisation(String name) {
        super(name);
        this.name = name;
    }
    
    public ReinbursementsFinanaceOrganisation() {
        super(Type.ReinbursementsFinanaceOrganisation.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new ReinAccountant());
        return roles;
    }  
    
}
