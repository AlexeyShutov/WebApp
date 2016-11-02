package com.dms.service;

import com.dms.domain.model.Authority;
import com.dms.domain.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority getById(Integer id) {
        Authority authority = authorityRepository.getById(id);
        if (authority == null)
            throw new EntityNotFoundException(String.format("Authority with id [%s] is not found", id));
        return authority;
    }
}
