/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {
    
    ArrayList<Restaurant> restrauntlist;
    
    
    public RestaurantDirectory(){
        restrauntlist = new ArrayList<>();
    }

    public ArrayList<Restaurant> getRestrauntlist() {
        return restrauntlist;
    }

    public void setRestrauntlist(ArrayList<Restaurant> restrauntlist) {
        this.restrauntlist = restrauntlist;
    }

    public Restaurant addRestraunt(){
        Restaurant restaurant = new Restaurant();
        restrauntlist.add(restaurant);
        return restaurant;
    }
    
    public void deleteRestaurant(Restaurant rest){
        restrauntlist.remove(rest);
    }

   
    
    
 
}
