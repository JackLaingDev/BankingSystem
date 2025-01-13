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

        switch (accountSetup.displayMenu()){
            case 1:
                login();
                break;
            case 2:
                register();
                break;
        }
    }

    public void login() throws SQLException {
        String userName = accountSetup.getUsername();
        String password = accountSetup.getPassword();

        // If login fails, retry accountSetup
        if(custServ.login(userName, password) == -1){
            accountSetup.loginFailure();
            accountSetup();
        }

        // Customer menu

    }

    public void register() throws SQLException {
        String userName = accountSetup.getNewUsername();
        String password = accountSetup.getNewPassword();
        String firstName = accountSetup.getFirstName();
        String lastName = accountSetup.getLastName();

        // If registration fails, retry accountSetup
        if (custServ.register(userName, password, firstName, lastName) == -1){
            accountSetup.registrationFailure();
            accountSetup();
        }

        // If successful, login
        custServ.login(userName, password);

        // Customer menu
    }

}
//int choice = scanner.nextInt();