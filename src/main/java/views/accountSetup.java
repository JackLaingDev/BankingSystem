package views;

import java.util.Scanner;

public class accountSetup {

    private Scanner scanner;
    private String mainMenu = "Please Enter An Option\n" +
            "1. Login\n" +
            "2. Create Account";

    public accountSetup(Scanner scanner){
        this.scanner = scanner;
    }

    public int displayMenu(){
        // Get main menu option
        System.out.println(mainMenu);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public String getUsername(){
        System.out.println("Please Enter Your Username:\n");
        return scanner.nextLine();
    }

    public String getPassword(){
        System.out.println("Please Enter Your Password:\n");
        return scanner.nextLine();
    }

    public String getNewUsername(){
        System.out.println("Please Enter Your New Username:\n");
        return scanner.nextLine();
    }

    public String getNewPassword(){
        System.out.println("Please Enter Your New Password:\n");
        return scanner.nextLine();
    }

    public String getFirstName(){
        System.out.println("Please Enter Your First Name:\n");
        return scanner.nextLine();
    }

    public String getLastName(){
        System.out.println("Please Enter Your Last Name:\n");
        return scanner.nextLine();
    }
}
