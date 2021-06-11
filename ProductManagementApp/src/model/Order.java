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
public class Order {
    
    ArrayList<OrderItem> orderitemlist;
    
    public Order(){
        this.orderitemlist  = new ArrayList<OrderItem>();
    }

    public ArrayList<OrderItem> getOrderitemlist() {
        return orderitemlist;
    }

    public void setOrderitemlist(ArrayList<OrderItem> orderitemlist) {
        this.orderitemlist = orderitemlist;
    }
    
    public void addorderitem(Product product, double price, int quantity){
        OrderItem orderitem = new OrderItem(product, price, quantity);
        orderitemlist.add(orderitem);
    }
    
    public OrderItem findProduct(Product product){
        for(OrderItem oi: this.getOrderitemlist()){
            if(oi.getProduct().equals(product)){
                return oi;
            }
        }
        return null;
    }
    
    public void removeitem(OrderItem item){
        orderitemlist.remove(item);
    }
    
    
    
}
