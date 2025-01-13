package views;

import models.Transaction;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class accountMenu {

    private Scanner scanner;
    private String mainMenu = "Please Enter An Option\n" +
            "1. Check Balance\n" +
            "2. Check Transactions\n" +
            "3. Close Account";

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
            System.out.printf("%d. Transaction ID: %d, Recipient ID: %d, Amount: £%.2f%n",
                    i+1,
                    transactions.get(i).getTransactionID(),
                    transactions.get(i).getRecipientID(),
                    transactions.get(i).getAmount());
        }
    }

}
