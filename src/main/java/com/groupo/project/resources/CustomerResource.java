package com.groupo.project.resources;

import com.groupo.project.models.Customer;
import com.groupo.project.services.CustomerService;
import com.groupo.project.models.Account;
import com.groupo.project.models.Movie;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Path to get into this section
@Path("/customers")

public class CustomerResource {
    private CustomerService CustomerService = new CustomerService();
    
    //get all custoemrs
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        //Return a list of all customers
        return CustomerService.getAllCustomers();
    }//End get al customers
    
    //create a customer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(Customer c) {
        //Creates a new customer and returns it
        return CustomerService.createCustomer(c);
    } //End create a customer
    
    //Get a specific customer
    @GET
    @Path("/{customerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getSpecificCustomer(@PathParam("customerID") int c_id ) {
        //gets customer for CustomerServices and returns it
	return CustomerService.getCustomer(c_id);
    }//End get a customer

    //Get specific account for specific customer
    @GET
    @Path("/{customerID}/accounts/{accountID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getCustomerAccount(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id ) {
        //Get specific customer from customers using id
        Customer cust = CustomerService.getCustomer(c_id);
        //Get a list of the accounts on that customer
        List<Account> accounts = cust.getAccounts();
        //Return the specific account from the array of accounts
	return accounts.get(a_id-1);
    }//End get specific account

    //Add a new account to a specific customer
    @POST
    @Path("/{customerID}/accounts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account addCustomerAccount(@PathParam("customerID") int c_id, Account account) {
        //Get the customer you will be adding the account to
        Customer cust = CustomerService.getCustomer(c_id);
        //Get a list of the accounts in that customer
        List<Account> accounts = cust.getAccounts();
        //Set the id of the account sent through the api to the size of the list +1
        account.setId(accounts.size()+1);
        //Add the new account to the list of accounts
        accounts.add(account);
        //Set the list of accounts within the customer to the updated list
        cust.setAccounts(accounts);
        //update the customer entry within customersService
        CustomerService.setCustomer(c_id, cust);
        //Return the newly create account
	return CustomerService.getCustomer(c_id).getAccounts().get(accounts.size()-1);
    }//End add a new account
    
    //Get all movies for a specific customer and account
    @GET
    @Path("/{customerID}/accounts/{accountID}/movies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id ) {
        //Get the customer specific in the URI
        Customer cust = CustomerService.getCustomer(c_id);
        //Get a list of accounts within the customer
        List<Account> accounts = cust.getAccounts();
        //get the account specific in the URI
        Account account = accounts.get(a_id-1);
        //Return the list of Movie objects in the account
	return account.getMovies();
    }//End get all movies for an account
    
    //get a specific movie for a specific customer and account
    @GET
    @Path("/{customerID}/accounts/{accountID}/movies/{movieID}")
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
    @Path("/{customerID}/accounts/{accountID}/movies")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> addCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id , Movie movie) {
        //Get the customer specified in the URI
        Customer cust = CustomerService.getCustomer(c_id);
        //Get a list of the accounts and then get the acount specified in the URI
        List<Account> accounts = cust.getAccounts();
        Account account = accounts.get(a_id-1);
        //Get a list of movies in the custoemrs account
        List<Movie> movies = account.getMovies();
        //Set the id of the Movie object passed in through the request
        movie.setId(movies.size()+1);
        //Add the movie to the list of movies
        movies.add(movie);
        //Set the new movies array to the account. Replace the account object in the array of Accounts. Set the arrayList in the customer object
        account.setMovies(movies);
        accounts.set(a_id-1, account);
        cust.setAccounts(accounts);
        //Set the updated customer to replace the old customer
        CustomerService.setCustomer(c_id, cust);
        //Return the updated movies list 
	return CustomerService.getCustomer(c_id).getAccounts().get(a_id-1).getMovies();
    }//End add a movie
    
    //Remove a movie from an account
    @DELETE
    @Path("/{customerID}/accounts/{accountID}/movies/{movieID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie setCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id , @PathParam("movieID") int m_id) {
        //Get the customer specified in the URI
        Customer cust = CustomerService.getCustomer(c_id);
        //Get a list of the accounts and then get the acount specified in the URI
        List<Account> accounts = cust.getAccounts();
        Account account = accounts.get(a_id-1);
        //Get a list of movies in the custoemrs account. get and Store the movie to be removed temporarily. Then remove it from the list.
        List<Movie> movies = account.getMovies();
        Movie temp = movies.get(m_id-1);
        movies.remove(m_id-1);
        //For loop to update the ID of all movies in the account.
        for(int i=0; i<movies.size(); i++){
            Movie temp1 = movies.get(i);
            temp1.setId(i+1);
            movies.set(i, temp1);
        }//End for loop
        //Set the movies List in the account
        account.setMovies(movies);
        //Replace the old account in the array of accounts with the new one
        accounts.set(a_id, account);
        //Set the array of account in the customer 
        cust.setAccounts(accounts);
        //Replace the old customer with the new one in the CustomerService
        CustomerService.setCustomer(c_id, cust);
        //Return the movie object that was removed
        return temp;
    }//End remove a movie
    
    //Transfer a movie (movieID) from account (accountID) to account2 (account2ID)
    @PATCH
    @Path("/{customerID}/accounts/{accountID}/movies/{movieID}/accounts2/{accounts2ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie setCustomerAccountMovie(@PathParam("customerID") int c_id, @PathParam("accountID") int a_id , @PathParam("movieID") int m_id, @PathParam("accounts2ID") int a2_id) {
        //Get the customer specified in the URI
        Customer cust = CustomerService.getCustomer(c_id);
        //Get a list of the accounts and then get the acount specified in the URI
        List<Account> accounts = cust.getAccounts();
        Account account = accounts.get(a_id-1);
        //Get a list of movies in the custoemrs account. get and Store the movie to be removed temporarily. Then remove it from the list.
        List<Movie> movie = account.getMovies();
	Movie transferM = movie.get(m_id-1);
        movie.remove(m_id-1);
        //For loop to update the ID of all movies in the account.
        for(int i=0; i<movie.size(); i++){
            Movie temp1 = movie.get(i);
            temp1.setId(i+1);
            movie.set(i, temp1);
        }//End for loop
        //Set the movies List in the account
        account.setMovies(movie);
        //Replace the old account in the array of accounts with the new one
        accounts.set(a_id-1, account);
        
        //Get the new account that the movie will be transfered to
        account = accounts.get(a2_id-1);
        //Get the list of movies from the account
        movie = account.getMovies();
        //Set the ID of the temporarily held movie to be the next id in the nest accounts movie list.
        transferM.setId(movie.size()+1);
        //Add the temp movie to the list of movies in the new account
        movie.add(transferM);
        //Set the movies in the account
        account.setMovies(movie);
        //update the account in the list of accounts
        accounts.set(a2_id-1, account);
        
        //Update the array of accounts in the customer
        cust.setAccounts(accounts);
        //Update the customer in the CustomerService
        CustomerService.setCustomer(c_id, cust);
        //Return the movie that was transfered
        return transferM;
    }//End transfer a movie
    
}//End class
