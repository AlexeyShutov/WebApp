package com.dms.service;

import com.dms.domain.model.User;
import com.dms.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getById(Integer id) {
        User user = userRepository.getById(id);
        if (user == null)
            throw new EntityNotFoundException(String.format("User with id [%d] is not found", id));

        return user;
    }

    public User getByUsername(String username) {
        User user = userRepository.getByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return user;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void add(User user) {
        userRepository.add(user);
    }

    @Transactional
    public void update(User user) {
        getById(user.getId());
        userRepository.update(user);
    }

    @Transactional
    public void delete(Integer id) {
        userRepository.delete(getById(id));
    }
}