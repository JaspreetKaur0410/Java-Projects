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
public class MasterOrderList {
    
    ArrayList<Order> orderlist;
    
    public MasterOrderList(){
        orderlist = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(ArrayList<Order> orderlist) {
        this.orderlist = orderlist;
    }
    
    public void addNewOrder(Order order){
        orderlist.add(order);
    }
    
    
}
