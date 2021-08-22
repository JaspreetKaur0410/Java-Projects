/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CulturalEvents;

import java.util.ArrayList;

/**
 *
 * @author jaspr
 */
public class CulturalEventsHistory {
    
    private ArrayList<CulturalEvents> eventslist;
    
    public CulturalEventsHistory(){
        eventslist = new ArrayList<CulturalEvents>();
    }

    public ArrayList<CulturalEvents> getEventslist() {
        if(eventslist == null){
            eventslist = new ArrayList<CulturalEvents>();
        }
        return eventslist;
    }

    public void setEventslist(ArrayList<CulturalEvents> eventslist) {
        this.eventslist = eventslist;
    }
 
    
}
