/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BackgroundCheckManagerRole;
import Business.Role.FosterAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class BackgroundCheckOrganisation extends Organization{
    
    String name;
    public BackgroundCheckOrganisation(String name) {
        super(name);
        this.name = name;
    }
    
    public BackgroundCheckOrganisation() {
        super(Type.BackgroundCheckOrganisation.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new BackgroundCheckManagerRole());
        return roles;
    }
    
}
