package com.iebook.controller;

import com.iebook.service.BookService;
import com.iebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/homebook")
    public String homeBook (Model model) {
        return "/book/home_book";
    }

    @RequestMapping(path = "/updateOrSaveBook")
    public String updateOrSaveBook () {
        return "/book/updateOrSaveBook";
    }
}
