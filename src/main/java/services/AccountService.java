package services;

import models.Transaction;
import services.DatabaseService;
import services.TransactionService;

import models.Account;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AccountService{

    // Attributes
    private Account account;
    private DatabaseService db;
    private TransactionService transServ;

    // Constructor
    public AccountService(Account account, DatabaseService db) {
        this.account = account;
        this.db = db;
    }

    // Getters and Setters
    public Account getAccount(){return account;}
    public List<Transaction> getTransactions() throws SQLException{return this.db.getAccTransactions(this.account);}

    public void setAccount(Account account){this.account = account;}
    public void setTransServ(TransactionService transServ){this.transServ = transServ;}

    // Methods
    public void createAccount() throws SQLException {
        db.createAccount(this.account);
    }

    public void closeAccount() throws SQLException {
        db.deleteAccount(this.account);
    }

    public void makeTransaction(Transaction transaction) throws SQLException {
        DatabaseService db = new DatabaseService();
        transServ.setTransaction(transaction);

        Account recipientAccount = db.getAccount(transaction.getRecipientID());

        BigDecimal amount = transaction.getAmount();

        BigDecimal newAmountSender = this.account.getBalance().subtract(amount);
        BigDecimal newAmountRecipient = recipientAccount.getBalance().add(amount);

        // Check if sender account has enough money, and that the amount sent is valid
        if(newAmountSender.compareTo(BigDecimal.ZERO) >= 0 && amount.compareTo(BigDecimal.ZERO) >= 0) {
            db.setAccountBalance(this.account, newAmountSender);
            db.setAccountBalance(recipientAccount, newAmountRecipient);
            transServ.createTransaction();
        }
    }

}