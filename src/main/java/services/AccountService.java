package services;

import models.Transaction;
import services.DatabaseService;

import models.Account;

import java.math.BigDecimal;
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

    public void makeTransaction(Transaction transaction) throws SQLException {
        DatabaseService db = new DatabaseService();

        Account recipientAccount = db.getAccount(transaction.getRecipientID());

        BigDecimal amount = transaction.getAmount();

        BigDecimal newAmountSender = account.getBalance().subtract(amount);
        BigDecimal newAmountRecipient = recipientAccount.getBalance().add(amount);

        // Check if sender account has enough money, and that the amount sent is valid
        if(newAmountSender.compareTo(BigDecimal.ZERO) >= 0 && amount.compareTo(BigDecimal.ZERO) >= 0) {
            db.setAccountBalance(account, newAmountSender);
            db.setAccountBalance(recipientAccount, newAmountRecipient);
        }
    }

}