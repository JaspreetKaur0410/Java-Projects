/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

/**
 *
 * @author jaspr
 */
public class Item {
    
    private String itemname;
    private Double itemprice;
    private Character sizearr[] = new Character[3];
    private int itemid;
    
    public Item(){
       itemid++;
    }
    
    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Double getItemprice() {
        return itemprice;
    }

    public void setItemprice(Double itemprice) {
        this.itemprice = itemprice;
    }

    

    public Character[] getSizearr() {
        return sizearr;
    }

    public void setSizearr(Character[] sizearr) {
        this.sizearr = sizearr;
    }

    @Override
    public String toString() {
        return itemname;
    }

}
