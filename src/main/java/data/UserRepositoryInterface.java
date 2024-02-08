package data;

import models.User;

import java.util.List;

public interface UserRepositoryInterface {
    public List<User> fetchUsers();
    public User fetchUserById(int id);
    public User addUser(User user);
    public User updateUser(User user);
    public boolean deleteUser(int id);
}
