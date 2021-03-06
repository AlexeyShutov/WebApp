package com.dms.controller;

import com.dms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping
    public String adminPage(ModelMap model) {
        model.addAttribute("currentUser", super.getCurrentUsername());
        return "admin";
    }

    @RequestMapping(value = "/userManagement", method = RequestMethod.GET)
    public String userManagement(ModelMap model) {
        model.addAttribute("currentUser", super.getCurrentUsername());
        return "user-management";
    }
}
