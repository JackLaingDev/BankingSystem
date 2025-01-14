package services;

import models.Transaction;

import java.sql.SQLException;

public class TransactionService {

    // Attributes
    private Transaction transaction;
    private final DatabaseService db;

    // Constructor
    public TransactionService(Transaction transaction, DatabaseService db){
        this.transaction = transaction;
        this.db = db;
    }

    // Getters and Setters
    public Transaction getTransaction(){return transaction;}
    public void setTransaction(Transaction transaction){this.transaction = transaction;}

    // Methods
    public void saveTransaction() throws SQLException {db.createTransaction(transaction);}

}
