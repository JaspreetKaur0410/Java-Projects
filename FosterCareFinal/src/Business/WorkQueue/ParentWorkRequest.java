/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Child.Child;
import Business.Parent.Parent;

/**
 *
 * @author jaspr
 */
public class ParentWorkRequest extends WorkRequest{
    
    Parent parent;
    Child child;

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

    @Override
    public String toString() {
        return child.getUsername();
    }
    
    
    
}
