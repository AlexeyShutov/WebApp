package com.dms.controller;

import com.dms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping
    public String adminPage(ModelMap modelMap) {
        return "admin";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        adminService.adminTest();
        return "admin";
    }
}
