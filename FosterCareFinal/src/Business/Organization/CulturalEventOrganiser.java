/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CulturalEventManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class CulturalEventOrganiser extends Organization{
    
    String name;
    public CulturalEventOrganiser(String name) {
        super(name);
        this.name = name;
    }
    
    public CulturalEventOrganiser() {
        super(Type.CulturalEventOrganiser.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList();
        roles.add(new Business.Role.CulturalEventOrganiser());
        return roles;
    }  
    
}
