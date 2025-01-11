package main;

import controllers.Controller;

import services.DatabaseService;
import services.CustomerService;
import services.AccountService;

import models.Customer;
import models.Account;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Create a new Customer object
        Customer customer = new Customer(6,"John", "Doe", "johndoe", "password123");

        // Create a CustomerService object (assuming it has a constructor to set the customer)
        CustomerService customerService = new CustomerService(customer);

        // Get the customer's accounts using CustomerService
        List<Account> accounts = customerService.getAccounts();

        // Display the retrieved accounts
        System.out.println("Customer Accounts:");
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getAccountID() + ", Account Type: " + account.getAccountType());
        }

    }
}