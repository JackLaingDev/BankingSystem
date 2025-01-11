package services;

import services.DatabaseService;

import models.Account;

public class AccountService{

    // Attributes
    private Account account;
    DatabaseService db = new DatabaseService();

    // Constructor
    public AccountService(Account account){
        this.account = account;
    }

    // Getters and Setters
    public Account getAccount(){return account;}
    public void setAccount(Account account){this.account = account;}

    // Methods


}