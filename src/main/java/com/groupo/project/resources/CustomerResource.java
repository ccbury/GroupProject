package com.groupo.project.resources;

import com.groupo.project.models.Customer;
import com.groupo.project.services.CustomerService;
import com.groupo.project.models.Account;
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
    
    //get all accounts
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return CustomerService.getAllCustomers();
    }
	
    //create an account
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(@PathParam("CustomerID") int c_id, Customer c) {
        return CustomerService.createCustomer(c);
    } 
    
    @GET
    @Path("/{customerID}/account")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getCustomerAccount(@PathParam("customerID") int c_id ) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
	return accounts;
    }
    @GET
    @Path("/{customerID}/account/{accountID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getCustomerAccount(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id ) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
	return accounts.get(a_id-1);
    }
    
    @POST
    @Path("/{customerID}/account/{accountID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account getCustomerAccount(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id , Account account) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
        account.setId(a_id);
        accounts.add(a_id-1, account);
	return accounts.get(a_id-1);
    }
}
