package com.groupo.project.resources;

import com.groupo.project.models.Account;
import com.groupo.project.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class AccountResource {
    private AccountService AccountService = new AccountService();
    
    //get all accounts
    @GET
    public List<Account> getAccounts(@PathParam("accountID") int a_id) {
	return AccountService.getAllAccounts();
    }
	
    //create an account
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postAccount(@PathParam("accountID") int a_id, Account a) {
        return AccountService.createAccount(a);
    } 
}
