package ang.springboot.dao;


import ang.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }
    @Transactional
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
    @Transactional
    public void updateUser(int id, User user) {
        User userToBeUpdated = entityManager.find(User.class, id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setAge(user.getAge());
    }
    @Transactional
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT users FROM User users", User.class).getResultList();
    }



}