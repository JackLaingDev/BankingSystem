package services;

import services.DatabaseService;

import models.Customer;
import models.Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    // Attributes
    private Customer customer;
    private DatabaseService db;

    // Constructor
    public CustomerService(Customer customer, DatabaseService db){
        this.customer = customer;
        this.db = db;
    }

    // Getters and Setters
    public Customer getCustomer(){return customer;}
    public List<Account> getAccounts() throws SQLException{return db.getCustAccounts(customer);}

    public void setCustomer(Customer customer){this.customer = customer;}

    //Methods
    public void createCustomer() throws SQLException {
        db.createCustomer(customer);
    }

    public void closeCustomer() throws SQLException{
        db.deleteCustomer(customer);
    }

    public void login(String userName, String password) throws SQLException {

        Customer customer = db.getCustomer(userName);
        String custPassword = customer.getPassword();

        if(customer == null){
            System.out.println("No Customer With This Username exists");
        }
        else if (customer.getIsClosed()) {
            System.out.println("This Customer Account Is Closed");
        }
        else if (custPassword.equals(password)) {
            this.customer = customer;
            System.out.println("Customer Successfully Logged In");
        }
    }
}
