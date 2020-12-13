package com.groupo.project.services;

import com.groupo.project.databases.Database;
import com.groupo.project.models.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customer = Database.getCustomersDB();
    
    public List<Customer> getAllCustomers() {
        return customer;
    }
    
    public Customer getCustomer(int id) {
        return customer.get(id-1);
    }
    
    public Customer createCustomer(Customer c) {
        c.setId(customer.size() + 1);
	customer.add(c);
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(c.getId()));
	return c;
    }
    
    public List<Customer> getSearchAccounts(String name) {
        List<Customer> matcheslist = new ArrayList<>();
      
        for (Customer q: getAllCustomers()) {
            if ((name == null || q.getName().equals(name))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;
    }  
}
