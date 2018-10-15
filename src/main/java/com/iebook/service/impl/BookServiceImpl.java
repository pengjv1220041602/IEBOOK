package com.iebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iebook.dao.BookDao;
import com.iebook.entry.Book;
import com.iebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public PageInfo<Book> listBook(Book book) {
        PageHelper.startPage(book.getPage(), book.getSize());
        return new PageInfo(bookDao.listBook());
    }

    @Override
    public List<Book> listBookByCondition(Book book) {
        return null;
    }

    @Override
    public int saveBook(Book book) {
        return 0;
    }

    @Override
    public int updateBook(Book book) {
        return 0;
    }
}
