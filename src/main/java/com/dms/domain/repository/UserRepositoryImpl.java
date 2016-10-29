package com.dms.domain.repository;

import com.dms.domain.model.Identity;
import com.dms.domain.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User getByUsername(String username) {
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public Set getAll() {
        return null;
    }

    @Override
    public Optional get(Integer id) {
        return null;
    }

    @Override
    public Set get(Predicate predicate) {
        return null;
    }

    @Override
    public void add(Identity entity) {

    }

    @Override
    public Identity update(Identity entity) {
        return null;
    }

    @Override
    public void delete(Identity entity) {

    }
}
