/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CulturalEvents;

import java.util.Date;

/**
 *
 * @author jaspr
 */
public class CulturalEvents {
    
    String eventname;
    Date eventdate;
    String venue;
    String organisername;
    String eventcategory;
    private boolean isCulturalEventHappening;
    private boolean isRein;
    
    CulturalEventsHistory history;
    
    public CulturalEvents(){
        
    }

    public boolean isIsRein() {
        return isRein;
    }

    public void setIsRein(boolean isRein) {
        this.isRein = isRein;
    }
    
    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getOrganisername() {
        return organisername;
    }

    public void setOrganisername(String organisername) {
        this.organisername = organisername;
    }

    public String getEventcategory() {
        return eventcategory;
    }

    public void setEventcategory(String eventcategory) {
        this.eventcategory = eventcategory;
    }

    public CulturalEventsHistory getHistory() {
        return history;
    }

    public void setHistory(CulturalEventsHistory history) {
        this.history = history;
    }

    public boolean isIsCulturalEventHappening() {
        return isCulturalEventHappening;
    }

    public void setIsCulturalEventHappening(boolean isCulturalEventHappening) {
        this.isCulturalEventHappening = isCulturalEventHappening;
    }
    
    @Override
    public String toString() {
        return eventname;
    }

}
