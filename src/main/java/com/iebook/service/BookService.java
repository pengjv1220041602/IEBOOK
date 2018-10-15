package com.iebook.service;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.Book;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
public interface BookService {
    /**
     * @deprecation: 获取所有的图书列表
     *
     * @return: 图书列表
     */
    PageInfo<Book> listBook(Book book);

    /**
     * @deprecation: 获取图书列表通过条件查询
     *
     * @param: Book对象
     * @return:
     */
    List<Book> listBookByCondition(Book book);

    /**
     * @deprecation: 保存图书
     *
     * @param:
     * @return:
     */
    int saveBook (Book book);

    /**
     * @deprecation: 更新图书
     *
     * @param:
     * @return:
     */
    int updateBook (Book book);
}
