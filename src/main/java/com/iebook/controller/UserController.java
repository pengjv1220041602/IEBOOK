package com.iebook.controller;

import com.iebook.service.BookService;
import com.iebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:18
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/home")
    public String user () {
        return "/user/";
    }
}
