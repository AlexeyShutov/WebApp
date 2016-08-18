package com.dms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin")
    public String adminPage(ModelMap modelMap) {
        return "admin";
    }
}
