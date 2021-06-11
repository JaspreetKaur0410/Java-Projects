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
public class ProductCatalog {
    
    ArrayList<Product> productcatalog;
    
    public ProductCatalog(){
        this.productcatalog = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductcatalog() {
        return productcatalog;
    }

    public void setProductcatalog(ArrayList<Product> productcatalog) {
        this.productcatalog = productcatalog;
    }
    
    public Product addProduct(){
        Product p = new Product();
        productcatalog.add(p);
        return p;
    }
    
    public void removeProduct(Product p){
        productcatalog.remove(p);
    }
    
    
    
}
