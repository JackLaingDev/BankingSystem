package views;

import models.Transaction;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class accountMenu {

    private final Scanner scanner;
    private final String mainMenu = "Please Enter An Option\n" +
            "1. Check Balance\n" +
            "2. Check Transactions\n" +
            "3. Make Transaction\n" +
            "4. Deposit\n" +
            "5. Withdraw\n" +
            "6. Close Account\n" +
            "7. Go Back";

    public accountMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public int displayMenu(){
        // Get main menu option
        System.out.println(mainMenu);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayBalance(BigDecimal balance){
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Balance: " + df.format(balance));
    }

    public void displayTransactions(List<Transaction> transactions){
        DecimalFormat df = new DecimalFormat("#,###.00");

        for(int i = 0; i < transactions.size(); i++){
            System.out.printf("%d. Transaction ID: %d, Sender ID: %d, Recipient ID: %d, Amount: £%.2f%n",
                    i+1,
                    transactions.get(i).getTransactionID(),
                    transactions.get(i).getSenderID(),
                    transactions.get(i).getRecipientID(),
                    transactions.get(i).getAmount());
        }
    }

    public int getRecipientID(){
        System.out.println("Please Enter The Account ID You Want To Transfer To:\n");
        int recipientID = scanner.nextInt();
        scanner.nextLine();
        return recipientID;
    }

    public BigDecimal getTransferAmount(){
        System.out.println("Please Enter The Amount You Want To Transfer:\n");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();
        return amount;
    }

    public BigDecimal getWithdrawAmount(){
        System.out.println("Please Enter The Amount You Want To Withdraw:\n");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();
        return amount;
    }

    public BigDecimal getDepositAmount(){
        System.out.println("Please Enter The Amount You Want To Deposit:\n");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();
        return amount;
    }

    public void transactionSuccess(){
        System.out.println("Transaction Successful");
    }

    public void accountCloseSuccess(){
        System.out.println("Account Closed");
    }

    public void depositSuccess(){
        System.out.println("Deposit Successful");
    }

    public void withdrawSuccess(){
        System.out.println("Withdraw Successful");
    }

}
