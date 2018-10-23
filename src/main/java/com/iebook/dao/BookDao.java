package com.iebook.dao;

import com.iebook.dao.provider.BookDaoProvider;
import com.iebook.entry.Book;
import com.iebook.utils.Constants;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Mapper
public interface BookDao {

    @SelectProvider(type = BookDaoProvider.class, method = "getBook")
    Book getBook(Book book);

    @SelectProvider(type = BookDaoProvider.class, method = "listBook")
    List<Book> listBook();

    @SelectProvider(type = BookDaoProvider.class, method = "listBookByCondition")
    List<Book> listBookByCondition(Book book);

    @InsertProvider(type = BookDaoProvider.class, method = "saveBook")
    int saveBook (Book book);

    @UpdateProvider(type = BookDaoProvider.class, method = "updateBook")
    int updateBook(Book book);

    @UpdateProvider(type = BookDaoProvider.class, method = "lineOrDown")
    int lineOrDown(Book book);
}
