package models;

public class Transaction {

    // Attributes
    private int transactionID;
    private int senderID;
    private int recipientID;
    private int amount;

    // Constructor
    public Transaction(int transactionID, int senderID, int recipientID, int amount){
        this.transactionID = transactionID;
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.amount = amount;
    }

    // Getters and Setters
    public int getTransactionID(){return transactionID;}
    public void setTransactionID(int transactionID){this.transactionID = transactionID;}

    public int getSenderID(){return senderID;}
    public void setSenderID(int senderID){this.senderID = senderID;}

    public int getRecipientID(){return recipientID;}
    public void setRecipientID(int recipientID){this.recipientID = recipientID;}

    public int getAmount(){return amount;}
    public void setAmount(int amount){this.amount = amount;}

}