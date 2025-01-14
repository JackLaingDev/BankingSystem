# Banking System

## Overview

This project is a **banking system** implemented using the **Model-View-Controller (MVC)** design pattern. It provides functionalities for managing customers, accounts, and transactions within a banking context. The system uses **Java** for backend logic and **MySQL** as the database to store data persistently.

The project is organized into three primary layers:
1. **Models**: Represent the data structures (`Customer`, `Account`, `Transaction`).
2. **Services**: Handle business logic and database interactions.
3. **Controllers**: Manage the program flow and user interaction via command-line views.

---

## Features

### **Customer Management**
- Create and delete customer accounts.
- Unique username enforcement for customers.

### **Account Management**
- Create and close bank accounts.
- Retrieve account details and transaction history.
- Perform transactions (transfer funds between accounts).

### **Transaction Management**
- Record and store transactions in the database.
- Ensure database consistency through atomic operations during transactions.

---

## Architecture

### **Model-View-Controller (MVC) Design**
- **Models**: Define the data structures and constraints for `Customer`, `Account`, and `Transaction`.
- **Services**: Implement business logic and interact with the database.
  - **AccountService**: Handles operations related to accounts (e.g., creating accounts, making transactions).
  - **TransactionService**: Focuses on saving transaction records to the database.
  - **DatabaseService**: Manages low-level database interactions.
- **Controllers**: Coordinate the flow of data between models, services, and the command-line interface.

---

## Database Schema

The database includes the following tables:

### **1. Customers**
Stores customer details.
```sql
CREATE TABLE `customers` (
  `customerID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(20) NOT NULL,
  `lastName` VARCHAR(20) NOT NULL,
  `username` VARCHAR(20) NOT NULL UNIQUE,
  `password` VARCHAR(20) NOT NULL,
  `isClosed` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`customerID`)
);
```

### **2. Accounts**

Stores account information and links accounts to customers.

```sql
CREATE TABLE `accounts` (
  `accountID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `accountType` INT UNSIGNED NOT NULL DEFAULT 0,
  `balance` DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  `customerID` INT UNSIGNED NOT NULL,
  `isClosed` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`accountID`),
  FOREIGN KEY (`customerID`) REFERENCES `customers` (`customerID`) ON DELETE CASCADE
);
```

### **3. Transactions**

Records transactions between accounts.

```sql
CREATE TABLE `transactions` (
  `transactionID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `senderID` INT UNSIGNED NOT NULL,
  `recipientID` INT UNSIGNED NOT NULL,
  `amount` DECIMAL(10,2) UNSIGNED NOT NULL,
  PRIMARY KEY (`transactionID`),
  FOREIGN KEY (`senderID`) REFERENCES `accounts` (`accountID`),
  FOREIGN KEY (`recipientID`) REFERENCES `accounts` (`accountID`)
);
```

## **Key Classes and Responsibilities**

### 1. `AccountService`
Handles account-related operations:
- **Create and close accounts.**
- **Retrieve transaction history.**
- **Perform transactions between accounts:**
  - Validates the transaction (e.g., sufficient balance).
  - Updates account balances atomically.
  - Delegates transaction saving to `TransactionService`.

---

### 2. `TransactionService`
Handles transaction-related operations:
- **Saves transaction records to the database.**

---

### 3. `DatabaseService`
Manages database queries and updates:
- **CRUD (Create, Read, Update, Delete) operations** for `Customer`, `Account`, and `Transaction`.
- Provides utility methods for transaction and account management.

---

## Transaction Flow Example

1. **User Input:**  
   The controller prompts the user for details (e.g., sender ID, recipient ID, amount).

2. **Validation:**  
   `AccountService` validates the transaction:
   - Ensures sufficient funds in the sender’s account.
   - Ensures the recipient account exists.

3. **Balance Updates:**  
   `AccountService` updates the balances of both accounts.

4. **Transaction Recording:**  
   `TransactionService` saves the transaction to the database.

---

## Future Enhancements
- Add support for more account types (e.g., savings, credit).
- Implement user authentication with hashed passwords.
- Create a graphical user interface (GUI) for better user experience.
- Use connection pooling for improved database performance.
- Integrate automated testing for services.

---

## License
This project is licensed under the MIT License.

---

## Author
 **Jack Laing**  
  [GitHub](https://github.com/JackLaingDev)  
  [Email](mailto:jacklaing123@hotmail.co.uk)


