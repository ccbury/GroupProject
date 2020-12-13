package com.groupo.project.databases;

import com.groupo.project.models.Customer;
import com.groupo.project.models.Account;
import com.groupo.project.models.Movie;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Account> accountDB = new ArrayList<>();
    public static List<Customer> customerDB = new ArrayList<>();
    public static List<Movie> movieDB = new ArrayList<>();
    
    public static boolean init = true;
     
    public Database () {
      if (init) {
        Movie m1 = new Movie (1, "the", true, true, "good");
        Movie m2 = new Movie (2, "yes", true, false, "bad"); 
        Movie m3 = new Movie (3, "no", false, true, "okay");
        
        movieDB.add(m1);
        movieDB.add(m2);
        movieDB.add(m3);
        
        Account a1 = new Account (1, "george", "password", movieDB);  
        Account a2 = new Account (2, "Conor", "password", movieDB); 
        Account a3 = new Account (3, "Alex", "password", movieDB);
        
        accountDB.add(a1);
        accountDB.add(a2);
        accountDB.add(a3);
        
        Customer c1 = new Customer (1, "george", "georgealso@gmail.com", "address", accountDB);
        Customer c2 = new Customer (2, "Conor", "georgealso@gmail.com", "address", accountDB);
        Customer c3 = new Customer (3, "Alex", "georgealso@gmail.com", "address", accountDB);
        
        customerDB.add(c1);
        customerDB.add(c2);
        customerDB.add(c3);
        
        init = false;
     }
    }
    
    public static List<Account> getAccountsDB() {
        return accountDB;
    }
    
    public static List<Customer> getCustomersDB() {
        return customerDB;
    }
    
    public static List<Movie> getMoviesDB() {
        return movieDB;
    }
}