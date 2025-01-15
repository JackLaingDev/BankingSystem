package views;

import models.Account;

import java.util.List;
import java.util.Scanner;

public class customerMenu {

    private final Scanner scanner;
    private final String mainMenu = "Please Enter An Option\n" +
            "1. Choose Account\n" +
            "2. Open Account\n" +
            "3. Close Customer Account";

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

    public void customerCloseSuccess(){
        System.out.println("Customer Account Closed");
    }

    public void openCustAccountSuccess(){
        System.out.println("Successfully Opened An Account For Customer");
    }

}
