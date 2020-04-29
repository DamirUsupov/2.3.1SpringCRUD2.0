package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(Long id);
    User getUserByEmail(String email);
}
