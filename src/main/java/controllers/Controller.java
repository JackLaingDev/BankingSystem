package controllers;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import models.Account;
import models.Transaction;
import services.AccountService;
import services.CustomerService;
import services.TransactionService;
import services.DatabaseService;

import views.customerSetup;
import views.customerMenu;
import views.accountMenu;

public class Controller {

    // Attributes
    private final Scanner scanner;

    // Services
    private final AccountService accServ;
    private final CustomerService custServ;
    private final TransactionService transServ;
    private final DatabaseService db;

    // Views
    private final customerSetup customerSetup;
    private final customerMenu customerMenu;
    private final accountMenu accountMenu;

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
        this.accountMenu = new accountMenu(scanner);
    }

    public void run() throws SQLException {

        System.out.println("Starting up Banking System");
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

        int loginStatus = custServ.login(userName, password);

        // If login fails, retry customerSetup
        if(loginStatus == -1){
            customerSetup.accountNotFound();
            customerSetup();
        }
        else if(loginStatus == -2){
            customerSetup.accountIsClosed();
            customerSetup();
        }
        else if(loginStatus == -3){
            customerSetup.incorrectPassword();
            customerSetup();
        }
        else if (loginStatus == 0) {
            customerSetup.loginSuccess();
        }
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
                accountMenu();
                break;
            case 2:
                openAccount();
                customerMenu();
            case 3:
                closeCustomer();
                break;
        }
    }
    private void openAccount() throws SQLException{
        Account account = new Account(0, custServ.getCustomerID(), 0, BigDecimal.ZERO);
        accServ.setAccount(account);
        accServ.createAccount();
        customerMenu.openCustAccountSuccess();
    }
    private void chooseAccount() throws SQLException {

        List<Account> accounts = custServ.getAccounts();
        int choice = customerMenu.displayAccounts(custServ.getAccounts());

        if(choice == accounts.size()+1){
            customerMenu();
        }

        accServ.setAccount(accounts.get(choice - 1));
    }
    private void closeCustomer() throws SQLException{
        custServ.closeCustomer();
        customerMenu.customerCloseSuccess();
        customerSetup();
    }
    private void accountMenu() throws SQLException {

        switch (accountMenu.displayMenu()){
            case 1:
                displayBalance();
                break;
            case 2:
                displayTransactions();
                break;
            case 3:
                makeTransaction();
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                closeAccount();
                break;
            case 7:
                chooseAccount();
                break;
        }
    }
    private void displayBalance() throws SQLException {
        BigDecimal balance = accServ.getAccBalance();

        accountMenu.displayBalance(balance);
        accountMenu();
    }
    private void displayTransactions() throws SQLException {

        List<Transaction> transactions = accServ.getTransactions();
        accountMenu.displayTransactions(transactions);
        accountMenu();
    }
    private void makeTransaction() throws SQLException{
        int recipientID = accountMenu.getRecipientID();
        int senderID = accServ.getAccountID();
        BigDecimal amount = accountMenu.getAmount();

        Transaction transaction = new Transaction(0, senderID,recipientID,amount);

        accServ.makeTransaction(transaction);
        accountMenu.transactionSuccess();
        accountMenu();
    }
    private void closeAccount() throws SQLException{
        accServ.closeAccount();
        accountMenu.accountCloseSuccess();
        chooseAccount();
    }

}
