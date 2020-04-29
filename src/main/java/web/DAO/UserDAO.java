package web.DAO;

import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);
}
