package com.dms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("currentUser", super.getCurrentUsername());
        return "index";
    }
}
