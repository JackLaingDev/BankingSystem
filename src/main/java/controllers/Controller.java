package controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import models.Account;
import services.AccountService;
import services.CustomerService;
import services.TransactionService;
import services.DatabaseService;

import views.customerSetup;
import views.customerMenu;

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
    private customerSetup customerSetup;
    private customerMenu customerMenu;

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

        this.customerSetup = new customerSetup(scanner);
        this.customerMenu = new customerMenu(scanner);
    }

    public void run() throws SQLException {
        // 0 = account set up
        // 1 = main menu

        // Initialise variables
        this.running = true;

        System.out.println("Starting up Banking System");

        // Have it so if a function fails (username taken etc.) it goes back to customerSetup
        customerSetup();

    }

    private void customerSetup() throws SQLException {

        switch (customerSetup.displayMenu()){
            case 1:
                login();
                break;
            case 2:
                register();
                break;
        }
    }

    private void login() throws SQLException {
        String userName = customerSetup.getUsername();
        String password = customerSetup.getPassword();

        // If login fails, retry customerSetup
        if(custServ.login(userName, password) == -1){
            customerSetup.loginFailure();
            customerSetup();
        }

        customerSetup.loginSuccess();

        // Customer menu
        customerMenu();
    }

    private void register() throws SQLException {
        String userName = customerSetup.getNewUsername();
        String password = customerSetup.getNewPassword();
        String firstName = customerSetup.getFirstName();
        String lastName = customerSetup.getLastName();

        // If registration fails, retry customerSetup
        if (custServ.register(userName, password, firstName, lastName) == -1){
            customerSetup.registrationFailure();
            customerSetup();
        }

        customerSetup.registrationSuccess();

        // If successful, login
        custServ.login(userName, password);
        customerSetup.loginSuccess();

        // Customer menu
        customerMenu();
    }

    private void customerMenu() throws SQLException {

        switch (customerMenu.displayMenu()){
            case 1:
                chooseAccount();
                break;
            case 2:
                custServ.closeCustomer();
                customerMenu.accountCloseSuccess();
                customerSetup();
                break;
        }
    }

    private void chooseAccount() throws SQLException {

        List<Account> accounts = custServ.getAccounts();
        int choice = customerMenu.displayAccounts(custServ.getAccounts());
        accServ.setAccount(accounts.get(choice - 1));
    }

}
//int choice = scanner.nextInt();