package com.iebook.controller;

import com.iebook.service.BookService;
import com.iebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Controller
public class BookController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;


}
