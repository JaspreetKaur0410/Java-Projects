/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Parent;

import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaspr
 */
public class ParentDirectory{
    
    List<Parent> parentlist;
    private ParentDirectory parentDirectory;
    
    public ParentDirectory(){
        parentlist = new ArrayList<Parent>();
    }

    public Parent addParent(){
     Parent parent = new Parent();
     //parentlist.add(parent);
     return parent;
    }
    
    public boolean isParentUnique(Parent parent){
        if(!parentlist.contains(parent)){
            return false;
        }
    return true;
    }

    public List<Parent> getParentlist() {
        return parentlist;
    }

    public void setParentlist(List<Parent> parentlist) {
        this.parentlist = parentlist;
    }

    public ParentDirectory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(ParentDirectory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }
    
    
    
}
