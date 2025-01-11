package services;

import services.DatabaseService;

import models.Transaction;

import java.sql.SQLException;

public class TransactionService {

    // Attributes
    private Transaction transaction;
    private DatabaseService db = new DatabaseService();

    // Constructor
    public TransactionService(Transaction transaction){
        this.transaction = transaction;
    }

    // Getters and Setters
    public Transaction getTransaction(){return transaction;}
    public void setTransaction(Transaction transaction){this.transaction = transaction;}

    // Methods
    public void createTransaction() throws SQLException {
        db.createTransaction(transaction);
    }

}
