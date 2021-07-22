/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {
    
    ArrayList<DeliveryMan> delmanlist;
    
    public DeliveryManDirectory(){
        delmanlist = new ArrayList<>();
    }
    
    public ArrayList<DeliveryMan> getDelmanlist() {
        return delmanlist;
    }

    public void setDelmanlist(ArrayList<DeliveryMan> delmanlist) {
        this.delmanlist = delmanlist;
    }
    
    public DeliveryMan createdelieverman(){
        DeliveryMan delman = new DeliveryMan();
        //delmanlist.add(delman);
        return delman;
    }
    
    public void deleteDelieveryMan(DeliveryMan delman){
        delmanlist.remove(delman);
    }
    
    
}
