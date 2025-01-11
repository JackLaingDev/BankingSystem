package services;

import services.DatabaseService;

import models.Account;

import java.sql.SQLException;

public class AccountService{

    // Attributes
    private Account account;
    DatabaseService db = new DatabaseService();

    // Constructor
    public AccountService(Account account) throws SQLException {
        this.account = account;
        db.createAccount(account);
    }

    // Getters and Setters
    public Account getAccount(){return account;}
    public void setAccount(Account account){this.account = account;}

    // Methods


}