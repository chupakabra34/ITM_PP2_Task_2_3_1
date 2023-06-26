package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * \* Create by Prekrasnov Sergei
 * \
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        // вернуть  createQuery от em .getResultList(); с показываением всех юзеров из User.class
        List<User> list = entityManager.createQuery("FROM User", User.class).getResultList();
        return list;
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void deleteUser(User deleteUser) {
        entityManager.remove(entityManager.contains(deleteUser) ? deleteUser : entityManager.merge(deleteUser));
    }
}