package controllers;

import services.*;
import java.util.Scanner;
import services.AccountService;
import services.CustomerService;

public class Controller {
    private Scanner scanner = new Scanner(System.in);


    public void run(){
        System.out.println("Starting up Banking System");

        // Display Main Menu IF LOGGED IN, if not, display accountSetup
        mainMenu();
    }

    /*
     * This will be the main functionalities ONCE LOGGED IN
     */
    public void mainMenu(){
        System.out.println("Please select an option\n" +
                "1. Check Balance\n" +
                "2. Transfer Funds\n" +
                "3. Close Account");
    }

    /*
     * This will be the log in options to vreate an account etc
     */
    public void accountSetup(){
        System.out.println("Please select an option\n" +
                "1. Create Account\n" +
                "2. Login");
    }
}
//int choice = scanner.nextInt();