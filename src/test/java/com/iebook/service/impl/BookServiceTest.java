package com.iebook.service.impl;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.Book;
import com.iebook.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001516:09
 * @Version 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void listBookTest () {
        Book book = new Book();
        book.setPage(1);
        book.setSize(1);
        PageInfo<Book> info = bookService.listBook(book);
        List<Book> list = info.getList();
        System.out.println(list);
    }
}
