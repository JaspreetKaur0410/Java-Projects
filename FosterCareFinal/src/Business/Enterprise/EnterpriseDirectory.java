/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;


import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EnterpriseDirectory extends Organization{
    private ArrayList<Enterprise> enterpriseList;

    
    public EnterpriseDirectory(){
       
        enterpriseList=new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Agency){
            enterprise=new Agency(name);
            enterpriseList.add(enterprise);
        }
        else if(type==Enterprise.EnterpriseType.HealthCare){
            enterprise=new HealthCare(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.Reinbursements)
        {
            enterprise = new Reinbursements(name);
            enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.CulturalEvents){
            enterprise = new CulturalEvents(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
    public boolean isUnique(String name){
        for(Enterprise enterprise : enterpriseList){
            if(name.equalsIgnoreCase(enterprise.getName())){
                return false;
            }
        }
        return true;
    }
    
    
    public void deleteEnterprise(Enterprise enterprise){
        enterpriseList.remove(enterprise);
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
