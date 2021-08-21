/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FosterOrganization;
import Business.Organization.LabOrganisation;
import Business.Organization.Organization;
import Business.Parent.ParentDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Doctor.DoctorWorkAreaJPanel;
import userinterface.LabortaryAssistant.LabortaryAssistantWorkAreaJPanel;

/**
 *
 * @author jaspr
 */
public class LabortaryAssistant extends Role{

    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, 
            Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory childdir, ParentDirectory parentdir) {
        return new LabortaryAssistantWorkAreaJPanel(userProcessContainer, account, network,
                (LabOrganisation)organization, enterprise, business,childdir,parentdir
        );
    }
    
    public String toString(){
        return (RoleType.LabortaryAssistant.getValue());
    } 
}
