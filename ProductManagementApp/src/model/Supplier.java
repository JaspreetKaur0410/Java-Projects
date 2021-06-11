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
public class Supplier {
    
    String supplyname;
    ProductCatalog productcatalog;
    
    public Supplier(){
        productcatalog = new ProductCatalog();
    }

    public String getSupplyname() {
        return supplyname;
    }

    public void setSupplyname(String supplyname) {
        this.supplyname = supplyname;
    }

    public ProductCatalog getProductcatalog() {
        return productcatalog;
    }

    public void setProductcatalog(ProductCatalog productcatalog) {
        this.productcatalog = productcatalog;
    }

    @Override
    public String toString() {
        return supplyname;
    }
    
    
            
    
}
