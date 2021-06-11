/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jaspr
 */
public class Business {
    
    MasterOrderList masterorderlist;
    SupplierDirectory supplierdirectory;
    
    public Business(){
        
        masterorderlist = new MasterOrderList();
        supplierdirectory = new SupplierDirectory();
    }

    public MasterOrderList getMasterorderlist() {
        return masterorderlist;
    }

    public void setMasterorderlist(MasterOrderList masterorderlist) {
        this.masterorderlist = masterorderlist;
    }

    public SupplierDirectory getSupplierdirectory() {
        return supplierdirectory;
    }

    public void setSupplierdirectory(SupplierDirectory supplierdirectory) {
        this.supplierdirectory = supplierdirectory;
    }
    
    
    
}
