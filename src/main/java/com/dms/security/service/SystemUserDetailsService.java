package com.dms.security.service;

import com.dms.domain.model.User;
import com.dms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SystemUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User user = userService.findUserByUsername(username);

        // if user is null throw exception

        // return SystemUserDetails(user);
        return null;
    }
}
