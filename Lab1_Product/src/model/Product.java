/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jaspr
 */
public class Product {
    
    private String name;
    private String desc;
    private int availnum;
    private int price;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getAvailnum() {
        return availnum;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAvailnum(int availnum) {
        this.availnum = availnum;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
