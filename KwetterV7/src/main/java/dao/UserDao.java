package dao;

import models.User;

import java.util.List;

public interface UserDao {
    public void createUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Long id);

}
