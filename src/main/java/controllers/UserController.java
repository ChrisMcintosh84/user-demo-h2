package controllers;

import data.UserRepositoryImpl;
import views.UserView;

public class UserController {
    private UserRepositoryImpl userRepository;
    private UserView userView;

    public UserController(UserRepositoryImpl userRepository, UserView userView) {
        this.userRepository = userRepository;
        this.userView = userView;
    }

    public void init() {
        processMainMenuInput();
    }

    private void processMainMenuInput() {
        int choice;

        while (true) {
            choice = userView.getMainMenuChoice();
            switch (choice) {
                case 1:
                    printUsers();
                    break;
                case 2:
                    System.out.println("add");
                    break;
                case 3:
                    System.out.println("edit");
                    break;
                case 4:
                    System.out.println("delete");
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void printUsers() {
        System.out.println(userRepository.fetchUsers());
    }
}
