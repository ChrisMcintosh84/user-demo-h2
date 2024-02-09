package controllers;

import data.UserRepositoryImpl;
import models.User;
import views.UserView;

import java.util.List;

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
                    processNewUser();
                    break;
                case 3:
                    processUpdatedUser();
                    break;
                case 4:
                    processUserToDelete();
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void processNewUser() {
        User user = userView.getNewUser();

        if (user != null) {
            int result = userRepository.addUser(user);

            if (result > 0) {
                System.out.println("New user added");
            }
            else {
                System.out.println("Unable to add user");
            }
        }
    }

    private void processUpdatedUser() {
        User user = userView.getUpdatedUser();
        List<User> userList = userRepository.fetchUsers();

        User tempUser = userList.stream()
                .filter(predicateUser -> user.getName().equals(predicateUser.getName()))
                .findAny()
                .orElse(null);

        if (tempUser != null) {
            user.setId(tempUser.getId());
            userRepository.updateUser(user);
            System.out.println("User updated");
        }
        else {
            System.out.println("User not found");
        }
    }

    private void processUserToDelete() {
        String name = userView.getUserToDelete();
        List<User> userList = userRepository.fetchUsers();

        User tempUser = userList.stream()
                .filter(predicateUser -> name.equals(predicateUser.getName()))
                .findAny()
                .orElse(null);

        if (tempUser != null) {
            userRepository.deleteUser(tempUser.getId());
        }
        else {
            System.out.println("User not found");
        }
    }

    private void printUsers() {
        System.out.println(userRepository.fetchUsers());
    }
}
