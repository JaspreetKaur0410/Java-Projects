/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.Customer;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
     public void addWorkRequest(WorkRequest workRequest){
       workRequestList.add(workRequest); 
    }
     
    public List<WorkRequest> getWorkRequestListCustomer(UserAccount account){
        List<WorkRequest> workRequestListCustomer = new ArrayList<>();
        for(WorkRequest workRequest : workRequestList){
            if(workRequest.getCustomer() != null){
                UserAccount customerAccount = workRequest.getCustomer();
                if(customerAccount.getUsername().equals(account.getUsername())){
                    workRequestListCustomer.add(workRequest);
                }
            }
        }
        return workRequestListCustomer;
    }
    
    public List<WorkRequest> getWorkRequestListRestaurant(UserAccount account){
        List<WorkRequest> workRequestListRestaurant = new ArrayList<>();
        for(WorkRequest workRequest : workRequestList){
            if(workRequest.getRestaurant() != null){
                UserAccount restuarantAccount = workRequest.getRestaurant();
                if(restuarantAccount.getUsername().equals(account.getUsername())){
                    workRequestListRestaurant.add(workRequest);
                }
            }
        }
        return workRequestListRestaurant;
    }
    public List<WorkRequest> getWorkRequestListDeliveryMan(UserAccount account){
        List<WorkRequest> workRequestListDelivery = new ArrayList<>();
        for(WorkRequest workRequest : workRequestList){
            if(workRequest.getDeliveryMan()!= null){
                UserAccount deliveryManAccount = workRequest.getDeliveryMan();
                if(deliveryManAccount.getUsername().equals(account.getUsername())){
                    workRequestListDelivery.add(workRequest);
                }
            }
        }
        return workRequestListDelivery;
    }
}