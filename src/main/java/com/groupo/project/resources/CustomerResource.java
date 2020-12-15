package com.groupo.project.resources;

import com.groupo.project.models.Account;
import com.groupo.project.models.Customer;
import com.groupo.project.services.AccountService;
import com.groupo.project.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customers")

public class CustomerResource {
    private CustomerService CustomerService = new CustomerService();
    
    //get all customers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return CustomerService.getAllCustomers();
    }
    
    //get all accounts (doesn't work)
    //@GET
    //@Path("/{accountID}")
    //@Produces(MediaType.APPLICATION_JSON)
    //public List<Account> getAccounts() {
        //return AccountService.getAllAccounts();
    //}
    
    //create a customer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(Customer c) {
        return CustomerService.createCustomer(c);
    }
    
    //get a customer based on the customer id
    @GET
    @Path("/{CustomerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("CustomerID")int c_id) {
        System.out.println("get Customer by ID: "+c_id);
        return CustomerService.getCustomer(c_id);
    }
    
    //get a account based on the customer id and account id (doesn't currently work)
    @GET
    @Path("/{CustomerID}/{accountID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("CustomerID")int c_id, @PathParam("AccountID")int a_id) {
        return getCustomer(c_id).getAccounts(a_id);
    }
}
