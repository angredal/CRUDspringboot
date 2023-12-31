package ang.springboot.service;

import ang.springboot.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void deleteUserById(int id);
    void updateUser(int id, User user);

    User getUserById(int id);

    List<User> getAllUsers();
}