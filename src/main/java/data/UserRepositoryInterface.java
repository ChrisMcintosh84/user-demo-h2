package data;

import models.User;

import java.util.List;

public interface UserRepositoryInterface {
    public List<User> fetchUsers();
    public User fetchUserById(int id);
    public int addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
