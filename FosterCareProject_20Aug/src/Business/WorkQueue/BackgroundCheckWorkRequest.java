/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Child.Child;
import Business.Parent.Parent;
import java.util.Date;

/**
 *
 * @author jaspr
 */
public class BackgroundCheckWorkRequest extends WorkRequest{
    
    private String comment;
    private String bgcStatus;
    private Parent parent;
    private Child child;
    private Date scheduleAppointment;
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
 
    }

    public String getBgcStatus() {
        return bgcStatus;
    }

    public void setBgcStatus(String bgcStatus) {
        this.bgcStatus = bgcStatus;
    } 

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Date getScheduleAppointment() {
        return scheduleAppointment;
    }

    public void setScheduleAppointment(Date scheduleAppointment) {
        this.scheduleAppointment = scheduleAppointment;
    }
    
    
    
    
}
