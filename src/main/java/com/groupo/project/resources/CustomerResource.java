package com.groupo.project.resources;

import com.groupo.project.models.Customer;
import com.groupo.project.services.CustomerService;
import com.groupo.project.models.Account;
import com.groupo.project.models.Movie;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customer")

public class CustomerResource {
    private CustomerService CustomerService = new CustomerService();
    
    //get all custoemrs
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return CustomerService.getAllCustomers();
    }
    //create a customer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(@PathParam("CustomerID") int c_id, Customer c) {
        return CustomerService.createCustomer(c);
    } 
    
    //Get accounts for specific customer
    @GET
    @Path("/{customerID}/account")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getCustomerAccount(@PathParam("customerID") int c_id ) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
	return accounts;
    }
    //Get specific account for specific customer
    @GET
    @Path("/{customerID}/account/{accountID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getCustomerAccount(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id ) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
	return accounts.get(a_id-1);
    }
    //Set a specific account for a specific customer
    @POST
    @Path("/{customerID}/account/{accountID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account setCustomerAccount(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id , Account account) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
        account.setId(a_id);
        accounts.add(a_id-1, account);
        cust.setAccounts(accounts);
	return accounts.get(a_id-1);
    }
    //Add a new account to a specific customer
    @POST
    @Path("/{customerID}/account")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account setCustomerAccount(@PathParam("customerID") int c_id, Account account) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
        account.setId(accounts.size() + 1);
        accounts.add(account);
        cust.setAccounts(accounts);
	return accounts.get(accounts.size()+1);
    }
    
    
    //Get all movies for a specific customer and account
    @GET
    @Path("/{customerID}/account/{accountID}/movie")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id ) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
        Account account = accounts.get(a_id-1);
	return account.getMovies();
    }
    //get a specific movie for a specific customer and account
    @GET
    @Path("/{customerID}/account/{accountID}/movie/{movieID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id, @PathParam("movieID") int m_id) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
        Account account = accounts.get(a_id-1);
        List<Movie> movie = account.getMovies();
	return movie.get(m_id-1);
    }

    
    //add a new movie for a specific customer and account
    @POST
    @Path("/{customerID}/account/{accountID}/movie")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Movie addCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id , Movie movie) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
        Account account = accounts.get(a_id-1);
        List<Movie> movies = account.getMovies();
        movie.setId(movies.size()+1);
        movies.add(movie);
        account.setMovies(movies);
        accounts.set(a_id-1, account);
        cust.setAccounts(accounts);
        CustomerService.setCustomer(c_id, cust);
	return CustomerService.getCustomer(c_id).getAccounts().get(a_id).getMovies().get(movies.size());
    }
    @DELETE
    @Path("/{customerID}/account/{accountID}/movie/{movieID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> setCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id , @PathParam("movieID") int m_id) {
        Customer cust = CustomerService.getCustomer(c_id);
        List<Account> accounts = cust.getAccounts();
        Account account = accounts.get(a_id-1);
        List<Movie> movies = account.getMovies();
        movies.remove(m_id-1);
        for(int i=0; i<movies.size(); i++){
            Movie temp = movies.get(i);
            temp.setId(i+1);
            movies.set(i, temp);
        }
        account.setMovies(movies);
        accounts.set(a_id, account);
        cust.setAccounts(accounts);
        CustomerService.setCustomer(c_id, cust);
        return  CustomerService.getCustomer(c_id).getAccounts().get(a_id).getMovies();
    }
}
