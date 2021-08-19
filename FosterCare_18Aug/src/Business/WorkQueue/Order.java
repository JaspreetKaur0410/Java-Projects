/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.Customer;
import Business.Restaurant.Item;
import Business.Restaurant.Restaurant;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author jaspr
 */
public class Order extends WorkRequest{
    
    String id;
    Double total;
    String customerfeedback;
    
    ArrayList<OrderItems> orderitemlist;
    
    public Order(ArrayList<OrderItems> orderitemlist){
        this.orderitemlist = orderitemlist;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString().substring(1,10);
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ArrayList<OrderItems> getOrderitemlist() {
        return orderitemlist;
    }

    public void setOrderitemlist(ArrayList<OrderItems> orderitemlist) {
        this.orderitemlist = orderitemlist;
    }
    
    public void addOrderItem(Item item, int quantity, String size){
        OrderItems orderitem = new OrderItems(item, quantity, size);
        orderitemlist.add(orderitem);
    }

    public String getCustomerfeedback() {
        return customerfeedback;
    }

    public void setCustomerfeedback(String customerfeedback) {
        this.customerfeedback = customerfeedback;
    }

    @Override
    public String toString() {
        return id.toString();
    }

}
