package controllers;

import java.util.Scanner;

import services.AccountService;
import services.CustomerService;
import services.TransactionService;
import services.DatabaseService;

public class Controller {
    private Scanner scanner;
    private AccountService accServ;
    private CustomerService custServ;
    private TransactionService transServ;
    private DatabaseService db;

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
    }

    public void run(){
        System.out.println("Starting up Banking System");

    }

}
//int choice = scanner.nextInt();