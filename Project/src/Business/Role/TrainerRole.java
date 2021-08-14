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
import Business.Organization.Organization;
import Business.Organization.TrainingOrganization;
import Business.Parent.ParentDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FosterAdmin.FosterAdminWorkAreaJPanel;
import userinterface.Trainer.TrainerWorkAreaJPanel;

/**
 *
 * @author jaspr
 */
public class TrainerRole extends Role{

    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, 
            Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory childdir, ParentDirectory parentdir) {
        return new TrainerWorkAreaJPanel(userProcessContainer, account, network,
                (TrainingOrganization)organization, enterprise, business,parentdir
        );
    }
    
    public String toString(){
        return (RoleType.Trainer.getValue());
    } 
}
