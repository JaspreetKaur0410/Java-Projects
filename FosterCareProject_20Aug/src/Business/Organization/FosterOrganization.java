/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.FosterAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class FosterOrganization extends Organization{
    
    String name;
    public FosterOrganization(String name) {
        super(name);
        this.name = name;
    }
    
    public FosterOrganization() {
        super(Type.FosterOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new FosterAdminRole());
        return roles;
    }
}
