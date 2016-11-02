package com.dms.domain.repository;

import com.dms.domain.model.Authority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthorityRepositoryImpl implements AuthorityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Authority getById(Integer id) {
        return entityManager.find(Authority.class, id);
    }

}
