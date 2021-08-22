/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import Business.Organization.Organization;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author jaspr
 */
public class ChildDirectory {
    
    public List<Child> childlist;
  
    public ChildDirectory(){
        childlist = new ArrayList<Child>();
        
    }
    
    public Child addChild(int caseno,
    String firstname,
    String lastname,
    String gender,
    int age,
    String city,
    String race,
    String religion,
   
    String about_child,
    Date last_profileupdated,
     String username, String password, Organization org, boolean specialchild, String photo)
    {
 
     Child child = new Child();
    
     child.setFirstname(firstname);
     child.setLastname(lastname);
     child.setGender(gender);
     child.setAge(age);
     child.setCity(city);
     child.setRace(race);
     child.setReligion(religion);
               
     child.setUsername(username);
     child.setPassword(password);
     child.setLast_profileupdated(last_profileupdated);
     
     child.setAbout_child(about_child);
     child.setCaseNo(caseno);
     child.setOrg(org);
     
     child.setImage(photo);
     if(specialchild){
         child.setIsSpecialChild(true);
     }
     else{
         child.setIsSpecialChild(false);
     }
     childlist.add(child);
     System.out.println(childlist);
     return child;
    }
    
    public void removeChild(Child child){
        childlist.remove(child);
    }

    public List<Child> getChildlist() {
        return childlist;
    }

    public void setChildlist(List<Child> childlist) {
        this.childlist = childlist;
    }

  
    
    public boolean isChildUnique(Child child){
        if(childlist.contains(child)){
            return false;
        }
        return true;
    }
    
    public void setChildAdopted(Child child){
        System.out.println(child.isIsAdopted());
        if(childlist.contains(child)){
            child.setIsAdopted(true);           
        }
        System.out.println(child.isIsAdopted());
    }
    
    
    
}
