package services;

import services.DatabaseService;

import models.Transaction;

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
}
