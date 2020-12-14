package com.groupo.project.resources;

import com.groupo.project.models.Account;
import com.groupo.project.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")

public class AccountResource {
    AccountService AccountService = new AccountService();
    
    //get all accounts
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts() {
        return AccountService.getAllAccounts();
    }
	
    //create an account
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postAccount(Account a) {
        return AccountService.createAccount(a);
    } 
    //get an account based on id
    @GET
    @Path("/{accountID}")
    public Account getAccount(@PathParam("accountID") int a_id ) {
    	System.out.println("get Account by ID: "+a_id );
	return AccountService.getAccount(a_id);
    }
    
}
