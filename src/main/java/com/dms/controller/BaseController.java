package com.dms.controller;

import com.dms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @Autowired
    UserService userService;

    public String getCurrentUsername() {
        return userService.getCurrentUsername();
    }
}
