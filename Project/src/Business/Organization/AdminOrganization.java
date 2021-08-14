/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class AdminOrganization extends Organization{
    
    String name;
    public AdminOrganization(String name) {
        super(name);
        this.name = name;
    }
    
    public AdminOrganization() {
        super(Type.AdminOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new AdminRole());
        return roles;
    }
}
