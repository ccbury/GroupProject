package com.groupo.project.resources;

import com.groupo.project.models.Customer;
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
    
}
