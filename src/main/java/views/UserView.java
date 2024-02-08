package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {
    private Scanner input = new Scanner(System.in);

    public int getMainMenuChoice() {
        System.out.println("---User Management---");
        System.out.println("1) List users");
        System.out.println("2) Add user");
        System.out.println("3) Edit user");
        System.out.println("4) Delete user");
        System.out.println("5) Exit");

        int choice = 0;

        try {
            choice = input.nextInt();
        }
         catch (InputMismatchException e) {
             System.out.println("Invalid input");
             input.nextLine();
         }

        return choice;
    }
}
