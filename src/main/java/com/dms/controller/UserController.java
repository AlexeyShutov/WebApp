package com.dms.controller;

import com.dms.domain.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody User user) {
        super.userService.add(user);
    }
}
