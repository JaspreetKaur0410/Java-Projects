/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class DeliveryMan extends UserAccount {
    
    private int delievrymanid;
    private String address;
    private int phone;
    private String name;
    
    public DeliveryMan(){
        delievrymanid++;
    }

    public int getDelievrymanid() {
        return delievrymanid;
    }

    public void setDelievrymanid(int delievrymanid) {
        this.delievrymanid = delievrymanid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
