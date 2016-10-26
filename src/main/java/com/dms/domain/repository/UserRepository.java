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
public class UserRepository<T extends Identity> implements BaseRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public User getByUsername(String username) {
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public Set<T> getAll() {
        return null;
    }

    @Override
    public Optional<T> get(Integer id) {
        return null;
    }

    @Override
    public Set<T> get(Predicate<T> predicate) {
        return null;
    }

    @Override
    public T add(T entity) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }
}
