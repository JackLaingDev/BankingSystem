package views;

import models.Account;

import java.util.List;
import java.util.Scanner;

public class customerMenu {

    private final Scanner scanner;
    private final String mainMenu = "Please Enter An Option\n" +
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

    public int displayAccounts(List<Account> accounts){
        System.out.println("Please Select An Account:\n");
        for(int i = 0; i < accounts.size(); i++){
            System.out.printf("%d. Account ID: %d\n", i+1, accounts.get(i).getAccountID());
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void accountCloseSuccess(){
        System.out.println("Account Closed");
    }

}
