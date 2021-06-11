/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class SupplierDirectory {
    
    private ArrayList<Supplier> supplierlist;
    
    public SupplierDirectory(){
        supplierlist = new ArrayList<Supplier>();
    }

    public ArrayList<Supplier> getSupplierlist() {
        return supplierlist;
    }

    public void setSupplierlist(ArrayList<Supplier> supplierlist) {
        this.supplierlist = supplierlist;
    }
    
    public Supplier addSupplier(){
       Supplier s = new Supplier();
       supplierlist.add(s);
       return s;
    }
    
    public void removeSupplier(Supplier s){
        supplierlist.remove(s);
    }
    
    
    
}
