package com.dms.service;

import com.dms.domain.model.User;
import com.dms.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User findByUsername(String username) {
        User user = userRepository.getByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return user;
    }
}
