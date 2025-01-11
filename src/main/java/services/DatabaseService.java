package services;

import java.math.BigDecimal;
import java.sql.*; // Import JDBC classes
import java.util.List;
import java.util.ArrayList;

import models.Customer;
import models.Transaction;
import models.Account;

public class DatabaseService {

    // DB Settings
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankingdb"; // Replace with your DB URL
    private static final String DB_USER = "root";     // Replace with your DB username
    private static final String DB_PASSWORD = "jacklaing"; // Replace with your DB password

    // Attributes
    private Connection connection;
    private String sql;

    // Constructor
    public DatabaseService() {
        try {
            // Load the JDBC driver (not strictly needed in modern JDBC but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection to DB established!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
            throw new RuntimeException("Error connecting to database", e); // Or rethrow as a custom exception
        }
    }

    // Methods
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public void createCustomer(Customer customer) throws SQLException{
        sql = "INSERT INTO customers (firstName, lastName, username, password) VALUES (?,?,?,?)";

        try(PreparedStatement statement = prepareStatement(sql)){
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUsername());
            statement.setString(4, customer.getPassword());

            statement.executeUpdate();
        }
    }

    public void createAccount(Account account) throws SQLException{
        sql = "INSERT INTO accounts (customerID) VALUES (?)";

        try(PreparedStatement statement = prepareStatement(sql)){
            statement.setInt(1, account.getCustomerID());

            statement.executeUpdate();
        }
    }

    public void createTransaction(Transaction transaction) throws SQLException{
        sql = "INSERT INTO transactions (senderID, recipientID, amount) VALUES (?,?,?)";

        try(PreparedStatement statement = prepareStatement(sql)){
            statement.setInt(1, transaction.getSenderID());
            statement.setInt(2, transaction.getRecipientID());
            statement.setBigDecimal(3, transaction.getAmount());

            statement.executeUpdate();
        }
    }

    public List<Account> getCustAccounts(Customer customer) throws SQLException{
        List<Account> accounts = new ArrayList<>();

        sql = "SELECT * FROM accounts WHERE customerID = ?";

        try(PreparedStatement statement = prepareStatement(sql)){
            statement.setInt(1, customer.getCustomerID());

            // Get resultSet
            try(ResultSet resultSet = statement.executeQuery()){

                // Iterate through resultSet, adding each account to accounts
                while(resultSet.next()){

                    // Get results
                    int accountID = resultSet.getInt("accountID");
                    int customerID = resultSet.getInt("customerID");
                    int accountType = resultSet.getInt("accountType");
                    BigDecimal balance = resultSet.getBigDecimal("balance");

                    // Create account object with results
                    Account account = new Account(accountID,customerID, accountType, balance);

                    // Add account to accounts
                    accounts.add(account);
                }
            }
        }

        return accounts;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*


    // Example usage (in AccountService or another service):
    public void updateAccountBalance(int accountId, int newBalance) throws SQLException {
        String sql = "UPDATE Account SET balance = ? WHERE accountID = ?";
        try (PreparedStatement statement = prepareStatement(sql)) {
            statement.setInt(1, newBalance); // Set the balance
            statement.setInt(2, accountId);  // Set the account ID
            statement.executeUpdate();
        }
    }*/