package services;

import services.DatabaseService;

import models.Customer;
import models.Account;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    // Attributes
    private Customer customer;
    private final DatabaseService db;

    // Constructor
    public CustomerService(Customer customer, DatabaseService db){
        this.customer = customer;
        this.db = db;
    }

    // Getters and Setters
    public List<Account> getAccounts() throws SQLException{return db.getCustAccounts(this.customer);}

    //Methods
    public void closeCustomer() throws SQLException{
        this.db.deleteCustomer(this.customer);
    }
    public int login(String userName, String password) throws SQLException {

        Customer customer = this.db.getCustomer(userName);
        String custPassword = customer.getPassword();

        if(customer == null){
            System.out.println("No Customer With This Username exists");
            return -1;
        }
        else if (customer.getIsClosed()) {
            System.out.println("This Customer Account Is Closed");
            return -1;
        }
        else if (custPassword.equals(password)) {
            this.customer = customer;
            return 0;
        }
        return -1;
    }
    public int register(String userName, String password, String firstName, String lastName) throws SQLException{
        Customer customer = new Customer(0, firstName, lastName, password, userName);

        try{
            db.createCustomer(customer);
            return 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            return -1;
        }
    }
}
