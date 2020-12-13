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