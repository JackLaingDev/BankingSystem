package controllers;

import java.sql.SQLException;
import java.util.Scanner;

import services.AccountService;
import services.CustomerService;
import services.TransactionService;
import services.DatabaseService;

import views.accountSetup;

public class Controller {

    // Attributes
    private Scanner scanner;
    private boolean running;

    // Services
    private AccountService accServ;
    private CustomerService custServ;
    private TransactionService transServ;
    private DatabaseService db;

    // Views
    private accountSetup accountSetup;

    public Controller(Scanner scanner,
                      AccountService accServ,
                      CustomerService custServ,
                      TransactionService transServ,
                      DatabaseService db){
        this.scanner = scanner;
        this.accServ = accServ;
        this.custServ = custServ;
        this.transServ = transServ;
        this.db = db;

        this.accountSetup = new accountSetup(scanner);
    }

    public void run() throws SQLException {
        // 0 = account set up
        // 1 = main menu

        // Initialise variables
        this.running = true;

        System.out.println("Starting up Banking System");
        while(running){

            // Have it so if a function fails (username taken etc.) it goes back to accountSetup
            accountSetup();

        }
    }

    public void accountSetup() throws SQLException {
        String userName = "";
        String password = "";
        String firstName = "";
        String lastName = "";

        switch (accountSetup.displayMenu()){
            case 1:
                userName = accountSetup.getUsername();
                password = accountSetup.getPassword();
                custServ.login(userName, password);
                break;
            case 2:
                userName = accountSetup.getNewUsername();
                password = accountSetup.getNewPassword();
                firstName = accountSetup.getFirstName();
                lastName = accountSetup.getLastName();
                custServ.register(userName, password, firstName, lastName);
                break;
        }
    }

}
//int choice = scanner.nextInt();