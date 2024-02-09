package views;

import models.User;

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

    public User getNewUser() {
        System.out.println("---Add User---");
        System.out.println("Enter name of user: ");
        String name = input.next();
        int age;
        double weight;

        try {
            System.out.println("Enter age: ");
            age = input.nextInt();
            System.out.println("Enter weight (in kgs): ");
            weight = input.nextDouble();

            return new User(name, age, weight);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid format");
            input.nextLine();
        }
        return null;
    }

    public User getUpdatedUser() {
        System.out.println("---Edit User---");
        System.out.println("Enter name of user to edit: ");
        String name = input.next();
        int age;
        double weight;

        try {
            System.out.println("Enter age: ");
            age = input.nextInt();
            System.out.println("Enter weight (in kgs): ");
            weight = input.nextDouble();

            return new User(name, age, weight);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid format");
            input.nextLine();
        }
        return null;
    }

    public String getUserToDelete() {
        System.out.println("---Delete User---");
        System.out.println("Enter name of user to delete: ");
        String name = input.next();

        System.out.println("Is this correct? (Y/N)");
        System.out.println("Name: " + name);
        String choice = input.next().toLowerCase();

        if (choice.equals("y")) {
            return name;
        }
        return null;
    }
}
