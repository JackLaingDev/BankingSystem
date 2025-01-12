package controllers;

import java.util.Scanner;

import services.AccountService;
import services.CustomerService;
import services.TransactionService;
import services.DatabaseService;

import views.accountSetup;

public class Controller {

    // Attributes
    private Scanner scanner;
    private boolean running;

    // Services
    private AccountService accServ;
    private CustomerService custServ;
    private TransactionService transServ;
    private DatabaseService db;

    // Views
    private accountSetup accountSetup;

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
        // 0 = account set up
        // 1 = main menu


        System.out.println("Starting up Banking System");
        while(true){

        }
    }

}
//int choice = scanner.nextInt();