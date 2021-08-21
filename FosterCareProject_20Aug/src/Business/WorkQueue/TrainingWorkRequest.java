/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Parent.Parent;

/**
 *
 * @author jaspr
 */
public class TrainingWorkRequest extends WorkRequest{
    
    private boolean isTrained;
    private Parent parent;

    public boolean isIsTrained() {
        return isTrained;
    }

    public void setIsTrained(boolean isTrained) {
        this.isTrained = isTrained;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    
    
    
}
