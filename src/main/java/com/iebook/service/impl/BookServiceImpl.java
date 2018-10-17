package com.iebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iebook.dao.BookDao;
import com.iebook.entry.Book;
import com.iebook.service.BookService;
import com.iebook.utils.Constants;
import com.iebook.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public PageInfo<Book> listBook(int page, int size, Book book) {
        PageHelper.startPage(page, size);
        return new PageInfo(bookDao.listBook());
    }

    @Override
    public PageInfo<Book> listBookByCondition(int page, int size, Book book) {
        PageHelper.startPage(page, size);
        return new PageInfo(bookDao.listBookByCondition(book));
    }

    @Override
    public boolean saveOrUpdateBook(Book book) {
        int result = 0;
        book.setUpdatedate(new Date());
        book.setExamine(Constants.ExamineCode.WAIT_EXAMINE);
        book.setFlag(Constants.Code.EXIST_CODE);
        book.setUpdateuid("1111111111111111111");
        if (StringUtils.isBlank(book.getId())) {
            book.setId(Utils.getUUID());
            book.setCreatedate(new Date());
            result = bookDao.saveBook(book);
        } else {
            result = bookDao.updateBook(book);
        }
        return result > 0;
    }
}
