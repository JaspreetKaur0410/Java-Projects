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
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.FosterOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Admin.AdminWorkArea;
import userinterface.FosterAdmin.FosterAdminWorkAreaJPanel;
import Business.Organization.FosterOrganization;
import Business.Parent.ParentDirectory;

/**
 *
 * @author jaspr
 */
public class AdminRole  extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Organization organization, Enterprise enterprise, 
            EcoSystem business,ChildDirectory childdir, ParentDirectory parentdir) {
        return new AdminWorkArea(userProcessContainer, account, network,
               organization, enterprise, business,childdir,parentdir);
    }
    
    public String toString(){
        return (RoleType.Admin.getValue());
    }  

    
}
