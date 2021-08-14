/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BackgroundCheckManagerRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class DoctorOrganisation extends Organization{
    
    String name;
    public DoctorOrganisation(String name) {
        super(name);
        this.name = name;
    }
    
    public DoctorOrganisation() {
        super(Type.DoctorOrganisation.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        return roles;
    }
    
}
