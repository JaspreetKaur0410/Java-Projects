/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CulturalEventManager;
import Business.Role.Role;
import Business.Role.TrainerRole;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class CulturalEventOrganisation extends Organization{
    
    String name;
    public CulturalEventOrganisation(String name) {
        super(name);
        this.name = name;
    }
    
    public CulturalEventOrganisation() {
        super(Type.CulturalEventOrganisation.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new CulturalEventManager());
        return roles;
    }  
    
}
