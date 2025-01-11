package services;

import services.DatabaseService;

import models.Customer;

import java.sql.SQLException;

public class CustomerService {

    // Attributes
    private Customer customer;
    private DatabaseService db = new DatabaseService();

    // Constructor
    public CustomerService(Customer customer){
        this.customer = customer;
    }

    // Getters and Setters
    public Customer getCustomer(){return customer;}
    public void setCustomer(Customer customer){this.customer = customer;}

    //Methods
    public void createCustomer() throws SQLException {
        db.createCustomer(customer);
    }

}
