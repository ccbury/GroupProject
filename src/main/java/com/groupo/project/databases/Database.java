package com.groupo.project.databases;

import com.groupo.project.models.Customer;
import com.groupo.project.models.Account;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Account> messageDB = new ArrayList<>();
    public static List<Customer> commentDB = new ArrayList<>();
    public static boolean init = true;
     
    public Database () {
      if (init) {
          

        
        init = false;
     }
    }
    
    public static List<Account> getMessagesDB() {
        return messageDB;
    }
    
    public static List<Customer> getCommentsDB() {
        return commentDB;
    }
}