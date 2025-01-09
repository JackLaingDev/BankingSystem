package services;

import models.Account;
import services.DatabaseService;

public class AccountService{

    // Attributes
    private Account account;

    // Constructor
    public AccountService(Account account){
        this.account = account;
    }

    // Getters and Setters
    public Account getAccount(){return account;}
    public void setAccount(Account account){this.account = account;}

    // Methods


}