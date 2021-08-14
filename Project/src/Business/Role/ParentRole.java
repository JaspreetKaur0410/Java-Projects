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
import Business.Organization.AdminOrganization;
import Business.Organization.FosterOrganization;
import Business.Organization.Organization;
import Business.Parent.ParentDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FosterAdmin.FosterAdminWorkAreaJPanel;
import userinterface.Parent.ParentWorkAreaJPanel;

/**
 *
 * @author jaspr
 */
public class ParentRole extends Role{

   
    public String toString(){
        return (RoleType.Parent.getValue());
    }   

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Organization organization, Enterprise enterprise, EcoSystem business,ChildDirectory childdir, ParentDirectory parentdir) {
        return new ParentWorkAreaJPanel(userProcessContainer, account, network,
                organization, enterprise, business,childdir,parentdir
        );
    }
}
