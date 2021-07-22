/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    
    ArrayList<Customer> customerlist;
    
    public CustomerDirectory(){
        customerlist = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(ArrayList<Customer> customerlist) {
        this.customerlist = customerlist;
    }
    
    public Customer addCustomer(){
        Customer customer = new Customer();
        customerlist.add(customer);
        return customer;
    }
    
    public void deleteCustomer(Customer customer){
        customerlist.remove(customer);
    }
    
}
