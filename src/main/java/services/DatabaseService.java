package services;

import java.sql.*; // Import JDBC classes

public class DatabaseService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankingdb"; // Replace with your DB URL
    private static final String DB_USER = "root";     // Replace with your DB username
    private static final String DB_PASSWORD = "jacklaing"; // Replace with your DB password

    private Connection connection;

    public DatabaseService() {
        try {
            // Load the JDBC driver (not strictly needed in modern JDBC but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
            throw new RuntimeException("Error connecting to database", e); // Or rethrow as a custom exception
        }
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