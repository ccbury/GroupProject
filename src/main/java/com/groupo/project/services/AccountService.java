package com.groupo.project.services;

import com.groupo.project.databases.Database;
import com.groupo.project.models.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    Database d = new Database();
    private List<Account> account = d.getAccountsDB();
    
    public List<Account> getAllAccounts() {
        return account;
    }
    
    public Account getAccount(int id) {
        return account.get(id-1);
    }
    
    public Account createAccount(Account a) {
        a.setId(account.size() + 1);
	account.add(a);
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(a.getId()));
	return a;
    }
    
    public List<Account> getSearchAccounts(String nickname) {
        List<Account> matcheslist = new ArrayList<>();
      
        for (Account q: getAllAccounts()) {
            if ((nickname == null || q.getNickname().equals(nickname))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;
    }
}
