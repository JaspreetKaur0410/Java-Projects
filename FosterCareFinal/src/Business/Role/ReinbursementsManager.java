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
import static Business.Organization.Organization.Type.PharmaOrganisation;
import Business.Organization.ReinbursementsOrganisation;
import Business.Parent.ParentDirectory;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ReinbursementsManager.ReinbursementsWorkAreaJPanel;


/**
 *
 * @author jaspr
 */
public class ReinbursementsManager extends Role{

    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, 
            Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory childdir, ParentDirectory parentdir) {
        return new ReinbursementsWorkAreaJPanel(userProcessContainer, account, network,
                (ReinbursementsOrganisation)organization, enterprise, business,childdir,parentdir
        );
    }
    
    public String toString(){
        return (RoleType.ReinbursementsManager.getValue());
    }   
    
}
