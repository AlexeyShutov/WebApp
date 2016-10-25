package com.dms.domain.repository;

import com.sun.javafx.geom.transform.Identity;

import java.util.Set;

public interface Repository<T extends Identity> {

    T add(T entity);
    T update(T entity);
    Set<T> get();
    void delete(T entity);
}
