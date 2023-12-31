package ang.springboot.service;

import ang.springboot.dao.UserDao;
import ang.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    UserDao userDao;
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }
}