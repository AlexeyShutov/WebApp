package com.dms.domain.repository;

import com.dms.domain.model.Identity;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Repository<T extends Identity> {

    Set<T> get();

    default Optional<T> get(Integer id) {
        return get()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

    default Set<T> get(Predicate<T> predicate) {
        return get()
                .stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }

    T add(T entity);

    T update(T entity);

    void delete(T entity);
}
