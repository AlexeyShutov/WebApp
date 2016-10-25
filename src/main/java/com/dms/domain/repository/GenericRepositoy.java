package com.dms.domain.repository;

import com.dms.domain.model.Identity;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class GenericRepositoy<T extends Identity> implements Repository<T> {

    @Override
    public Set<T> get() {
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
