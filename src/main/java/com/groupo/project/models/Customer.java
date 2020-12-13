package com.groupo.project.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private int id;    
    private String name;
    private String email;
    private String address;   
    private List<Account> accounts = new ArrayList<>();

    public Customer() {
    }

    public Customer(int id, String name, String email, String address, List<Account> accounts) {
        this.id = id;
        this.name= name;
        this.email = email;
        this.address = address;
        this.accounts=accounts;
    }
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public List<Account> getAccounts(){
        return accounts;
    }
    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }
    public void addAccount(Account account){
        (this.accounts).add(account);
    }
    
    public String printCustomer() {
        String str = "ID: "+this.getId()+"\tName: "+this.getName()+"\tEmail: "+this.getEmail()+"\tAddress: "+this.getAddress();
        return str;
    }
}
