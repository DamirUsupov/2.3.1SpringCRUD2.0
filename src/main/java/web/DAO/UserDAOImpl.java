package web.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.openSession().createQuery("from User");
        return query.getResultList();
    }


    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public User getUserById(Long id) {
        TypedQuery<User> q = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = :idPrm")
                .setParameter("idPrm", id);
        return q.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public User getUserByEmail(String email) {
        TypedQuery<User> q = sessionFactory.openSession().createQuery("FROM User WHERE email = :emailPrm")
                .setParameter("emailPrm", email);
        return q.getSingleResult();

    }
}
