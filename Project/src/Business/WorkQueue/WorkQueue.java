/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
      public void delete(int childId){
        List<WorkRequest> list = new ArrayList<>();
       for(WorkRequest wr:workRequestList) {
           if(childId==wr.getChildId()){
               list.add(wr);
               
           }
       }
       workRequestList.removeAll(list);
    }
}