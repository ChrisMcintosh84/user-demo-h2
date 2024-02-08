package data;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryInterface {
    @Override
    public List<User> fetchUsers() {
        String fetchQuery = "SELECT * FROM USERS";
        List<User> userList = null;

        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(fetchQuery);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            userList = new ArrayList<>();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("NAME"));
                user.setAge(resultSet.getInt("AGE"));
                user.setWeight(resultSet.getDouble("WEIGHT"));
                userList.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User fetchUserById(int id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
