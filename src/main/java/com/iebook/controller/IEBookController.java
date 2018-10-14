package com.iebook.controller;

import com.iebook.entry.User;
import com.iebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IEBookController {

    @Autowired
    private UserService userService ;

    @GetMapping("/user")
    @ResponseBody
    public User getUser () {
        return userService.getUser("1");
     }
}
