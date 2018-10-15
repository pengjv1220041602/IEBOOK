package com.iebook.dao;

import com.iebook.dao.provider.BookDaoProvider;
import com.iebook.entry.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Mapper
public interface BookDao {
    @Select("select * from tbook")
    List<Book> listBook();

    @SelectProvider(type = BookDaoProvider.class, method = "listBookByCondition")
    List<Book> listBookByCondition(Book book);

}
