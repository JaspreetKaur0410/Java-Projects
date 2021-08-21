/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author jaspr
 */
public class EventRequest extends WorkRequest{
    
    String eventname;
    Date eventdate;
    String venue;
    String organisername;
    String eventcategory;
    
    String id;
    
    public EventRequest(){
        UUID uuid = UUID.randomUUID();
        id = uuid.toString().substring(1,10);;
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

}
