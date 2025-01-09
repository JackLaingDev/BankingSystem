package models;

public class Customer {

    // Attributes
    private int customerID;
    private String firstName;
    private String lastName;

    // Constructor
    public Customer(int customerID, String firstName, String lastName){
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getCustomerID(){return customerID;}
    public void setCustomerID(int customerID){this.customerID = customerID;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String customerID){this.firstName = firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

}