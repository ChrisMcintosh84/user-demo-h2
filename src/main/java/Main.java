import controllers.UserController;
import data.UserRepositoryImpl;
import views.UserView;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        UserView userView = new UserView();

        UserController userController = new UserController(userRepository, userView);
        userController.init();
    }
}
