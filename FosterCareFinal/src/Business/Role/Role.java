/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Parent.ParentDirectory;
import Business.UserAccount.UserAccount;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    private RoleType type;

  
        
    
    public enum RoleType{
       Admin("Admin"),
       FosterAdmin("FosterAdmin"),
       Parent("Parent"),
       Child("Child"),
       BackgroundCheckManagerRole("BackgroundCheckManagerRole"),
       Trainer("Trainer"),
       Doctor("Doctor"),
       LabortaryAssistant("LabortaryAssistant"),
       Pharmacist("Pharmacist"),
       ReinbursementsManager("ReinbursementsManager"),
       ReinAccountant("ReinAccountant"),
       CulturalEventManager("CulturalEventManager"),
       CulturalEventOrganiser("CulturalEventOrganiser");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,Network network, Organization organization, Enterprise enterprise,EcoSystem business,ChildDirectory childdir, ParentDirectory parentdir);

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}