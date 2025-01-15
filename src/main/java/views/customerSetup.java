package views;

import java.util.Scanner;

public class customerSetup {

    private final Scanner scanner;
    private final String mainMenu = "Please Enter An Option\n" +
            "1. Login\n" +
            "2. Create Account";

    public customerSetup(Scanner scanner){
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

    public void accountNotFound(){
        System.out.println("No Account With This Username Exists");
    }

    public void accountIsClosed(){
        System.out.println("This Account Is Closed");
    }

    public void incorrectPassword(){
        System.out.println("This Password Is Incorrect");
    }

    public void registrationFailure(){
        System.out.println("Registration Failed, Please Try Again");
    }

    public void loginSuccess(){
        System.out.println("Customer Logged in!");
    }

    public void registrationSuccess(){
        System.out.println("Registration Successful");
    }

}
