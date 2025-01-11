package services;

import models.Transaction;
import services.DatabaseService;

import models.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AccountService{

    // Attributes
    private Account account;
    DatabaseService db = new DatabaseService();

    // Constructor
    public AccountService(Account account) {
        this.account = account;
    }

    // Getters and Setters
    public Account getAccount(){return account;}
    public List<Transaction> getTransactions() throws SQLException{return db.getAccTransactions(account);}

    public void setAccount(Account account){this.account = account;}

    // Methods
    public void createAccount() throws SQLException {
        db.createAccount(account);
    }

}