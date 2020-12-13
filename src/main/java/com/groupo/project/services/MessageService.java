/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupo.project.services;

import com.groupo.project.models.Account;
import com.groupo.project.models.Customer;
import com.mycompany.myblog.databases.Database;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
        
    Database d = new Database();
    private List<Account> list = d.getMessagesDB();
        
    public List<Account> getAllMessages() {
        return list;
    }
    
     public Account getMessage(int id) {
        return list.get(id-1);
    }  
     
     public Account createMessage(Account m) {
	m.setId(list.size() + 1);
      	list.add(m);
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(m.getId()));
        System.out.println("Updated Message:"+m.printMessage());
	return m;
    }
     
     public List<Account> getSearchMessages(String message, String author) {
        List<Account> matcheslist = new ArrayList<>();
        
        for (Account q: getAllMessages()) {
            if ((message == null || q.getMessage().equals(message)) 
                   && (author == null || q.getAuthor().equals(author))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;
    }

}
