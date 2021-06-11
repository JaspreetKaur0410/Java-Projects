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
public class OrderItem {
    
    Product product;
    double saleprice;
    int quantity;
    
    ArrayList<OrderItem> orderitemlist;
    
    public OrderItem(Product product, double saleprice, int quantity){
        this.product = product;
        this.saleprice = saleprice;
        this.quantity = quantity;
    }

    public ArrayList<OrderItem> getOrderitemlist() {
        return orderitemlist;
    }

    public void setOrderitemlist(ArrayList<OrderItem> orderitemlist) {
        this.orderitemlist = orderitemlist;
    }
    
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.product.toString();
    }
    
    
    
    
}
