package com.dms.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Secured("ROLE_ADMIN")
    public void adminTest() {
        System.out.println("admin");
    }
}
