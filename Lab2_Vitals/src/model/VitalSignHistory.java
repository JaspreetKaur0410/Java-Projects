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
public class VitalSignHistory extends Object{
    
    private ArrayList<VitalSigns> history;

    public ArrayList<VitalSigns> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<VitalSigns> history) {
        this.history = history;
    }
    
    
    
    public VitalSignHistory(){
        history = new ArrayList<>();
    }
    
    public VitalSigns createVital(){
        VitalSigns vs = new VitalSigns();
        history.add(vs);
        //System.out.println(vs.getBloodpressure());
        return vs;
    }
    
    public void deleteVital(String vs_str){
       for(int i=0;i<history.size();i++){
           if(history.get(i).getDate().equals(vs_str)){
               history.remove(history.get(i));
           }
        }
    }

    public VitalSigns viewVital(String vs_str) {
        for(int i=0;i<history.size();i++){
            if(history.get(i).getDate() == null ? vs_str == null : history.get(i).getDate().equals(vs_str)){
                return history.get(i);
            }
        }
        
        return history.get(0);    
    }
    
}
