package com.dms.domain.repository;

import com.dms.domain.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> rootUser = criteriaQuery.from(User.class);
        CriteriaQuery<User> allUsers = criteriaQuery.select(rootUser);
        TypedQuery<User> allQuery = entityManager.createQuery(allUsers);
        return allQuery.getResultList();
    }

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByUsername(String username) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.select(userRoot).where(criteriaBuilder.equal(userRoot.get("username"), username));
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();

        // Alternative with JPQL
//        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username")
//                .setParameter("username", username)
//                .getSingleResult();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        User userPersistent = getById(user.getId());

        if (userPersistent != null) {
            entityManager.getTransaction().begin();
            userPersistent.setFirstName(user.getFirstName());
            userPersistent.setLastName(user.getLastName());
            userPersistent.setEmail(user.getEmail());
            userPersistent.setCurrentPosition(user.getCurrentPosition());
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void delete(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}