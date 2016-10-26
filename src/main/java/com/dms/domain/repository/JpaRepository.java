package com.dms.domain.repository;

import com.dms.domain.model.Identity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class JpaRepository<T extends Identity> implements BaseRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

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
