package com.iebook.controller;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.Book;
import com.iebook.service.BookService;
import com.iebook.service.KindService;
import com.iebook.service.UserService;
import com.iebook.utils.Constants;
import com.iebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private KindService kindService;

    @RequestMapping(path = "/homebook")
    public String homeBook () {
        return "/book/home_book";
    }

    @RequestMapping(path = "/updateOrSaveBook")
    public String updateOrSaveBook () {
        return "/book/updateOrSaveBook";
    }

    @RequestMapping(path = "/bookform")
    public String bookform (Model model) {
        model.addAttribute("kinds", kindService.listKind());
        return "/book/bookform";
    }

    @RequestMapping(path = "/addbook", method = RequestMethod.POST)
    public Result addBook (Book book) {
        boolean count = bookService.saveOrUpdateBook(book);
        if (count) {
            return new Result("添加成功！", Constants.Code.SUCCESS_CODE, count, null);
        }
        return new Result("添加失败！", Constants.Code.ERROR_CODE, count, null);
    }

    @RequestMapping(path = "/listbook", method = RequestMethod.POST)
    @ResponseBody
    public Result listBook (int page, int size, Book book) {
        PageInfo<Book> pageInfo = bookService.listBook(page, size, book);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, pageInfo);
    }

    @RequestMapping("/examinebook")
    public String examineBook () {
        return "/book/examinebook";
    }

    @RequestMapping(path = "/examinebookdata")
    @ResponseBody
    public Result examineBookData (int page, int size, Book book) {
        PageInfo<Book> bookPageInfo = bookService.listBookByCondition(page, size, book);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, bookPageInfo);
    }
}
