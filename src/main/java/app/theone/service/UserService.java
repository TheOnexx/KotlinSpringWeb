package app.theone.service;

import app.theone.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void removeUser(long userId);
    List<User> allUsers();
    User getUser(long userId);
    boolean updateUser(User user);
}
