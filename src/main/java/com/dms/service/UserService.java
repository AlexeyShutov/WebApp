package com.dms.service;

import com.dms.domain.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User findByUsername(String username) {
        // TODO: temp empty user
        return new User();
    }
}
