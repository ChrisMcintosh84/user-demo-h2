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

        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(fetchQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            userList = new ArrayList<>();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("ID"));
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
    public int addUser(User user) {
        String addQuery = "INSERT INTO USERS (NAME, AGE, WEIGHT) VALUES (?, ?, ?)";

        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setDouble(3, user.getWeight());

            return preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void updateUser(User user) {
        String updateQuery = "UPDATE USERS SET AGE=?, WEIGHT=? WHERE ID=?";

        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, user.getAge());
            preparedStatement.setDouble(2, user.getWeight());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int id) {
        String deleteQuery = "DELETE FROM USERS WHERE ID=?";

        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
