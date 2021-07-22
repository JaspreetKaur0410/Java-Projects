/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class Menu {
    
    private ArrayList<Item> itemlist;
    
    public Menu(){
        itemlist = new ArrayList<>();
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<Item> itemlist) {
        this.itemlist = itemlist;
    }
    
    public Item addItem(){
        Item item = new Item();
        itemlist.add(item);
        return item;
    }
    
    public void deleteItem(Item item){
        itemlist.remove(item);
    }

}
