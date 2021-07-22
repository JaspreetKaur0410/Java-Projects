/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Restaurant.Item;

/**
 *
 * @author jaspr
 */
public class OrderItems {
    
    Item item;
    int quantity;
    String size;
    
    public OrderItems(Item item, int quantity, String size){
       this.item = item;
       this.quantity = quantity;
       this.size = size;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return item.getItemname();
    }
    
    
    
}
