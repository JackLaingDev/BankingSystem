package main;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import controllers.Controller;

import services.CustomerService;
import services.AccountService;
import services.TransactionService;
import services.DatabaseService;

import models.Customer;
import models.Account;
import models.Transaction;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Initialise models
        Customer customer = new Customer(0, "", "", "", "");
        Account account = new Account(0, 0, 0, BigDecimal.ZERO);
        Transaction transaction = new Transaction(0,0,0,BigDecimal.ZERO);

        // Initialise services
        CustomerService custServ = new CustomerService(customer);
        AccountService accServ = new AccountService(account);
        TransactionService transServ = new TransactionService(transaction);
        DatabaseService db = new DatabaseService();

        // Initialise scanner
        Scanner scanner = new Scanner(System.in);

        // Initialise controller
        Controller controller = new Controller(scanner,accServ,custServ,transServ,db);

        controller.run();
    }
}