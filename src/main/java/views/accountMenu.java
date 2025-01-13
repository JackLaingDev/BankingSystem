package views;

import java.util.Scanner;

public class accountMenu {

    private Scanner scanner;
    private String mainMenu = "Please Enter An Option\n" +
            "1. Login\n" +
            "2. Create Account";

    public accountMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public int displayMenu(){
        // Get main menu option
        System.out.println(mainMenu);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

}
