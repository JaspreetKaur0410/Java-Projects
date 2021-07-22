/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Customer.Customer;
import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class Restaurant extends UserAccount{
    
    String name;
    int phone;
    String address;
    int restrauntid;
    Menu menu;
    Customer customer;
    
    public Restaurant(){
        restrauntid++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRestrauntid() {
        return restrauntid;
    }

    public void setRestrauntid(int restrauntid) {
        this.restrauntid = restrauntid;
    }

    public Menu getMenu() {
        if(menu == null){
            menu = new Menu();
        }
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
     public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return this.name;
    }
 
}
