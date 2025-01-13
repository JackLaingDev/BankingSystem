package views;

import models.Account;

import java.util.List;
import java.util.Scanner;

public class customerMenu {

    private Scanner scanner;
    private String mainMenu = "Please Enter An Option\n" +
            "1. Choose account\n" +
            "2. Close Customer Account";

    public customerMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public int displayMenu(){
        // Get main menu option
        System.out.println(mainMenu);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayAccounts(List<Account> accounts){
        for(int i = 0; i < accounts.size(); i++){
            System.out.printf("%d. Account ID: %d\n", i+1, accounts.get(i).getAccountID());
        }
    }

    public void accountCloseSuccess(){
        System.out.println("Account Closed");
    }

}
