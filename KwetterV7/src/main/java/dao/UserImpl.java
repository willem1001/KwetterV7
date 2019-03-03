package dao;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserImpl implements UserDao {

    @PersistenceContext(name = "KwetterPU")
    EntityManager em;

    public void createUser(User user) {
        em.persist(user);
    }

    public List<User> getAllUsers() {
        Query q = em.createQuery("SELECT u FROM User u");
        return (List<User>) q.getResultList();
    }

    public User getUserById(Long id) {
        Query q = em.createQuery("SELECT u FROM User u WHERE u.id = :id");
        q.setParameter("id", id);
        return (User) q.getSingleResult();
    }
}
