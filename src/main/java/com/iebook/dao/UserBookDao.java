package com.iebook.dao;

import com.iebook.dao.provider.UserBookDaoProvider;
import com.iebook.dao.provider.UserDaoProvider;
import com.iebook.entry.UserBook;
import com.iebook.utils.Constants;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/23 002315:00
 * @Version 1.0
 * @Description:
 */
@Mapper
public interface UserBookDao {
    @InsertProvider(type = UserBookDaoProvider.class, method = "saveUserBook")
    int saveUserBook(UserBook userBook);
    @UpdateProvider(type = UserBookDaoProvider.class, method = "updateUserBook")
    int updateUserBook(UserBook userBook);
    @Select("select * from tuserbook where tuserbook.bookid = #{bookid} and tuserbook.userid = #{userid} and tuserbook.flag = #{flag}")
    UserBook getUserBook (UserBook userBook) ;
    @SelectProvider(type = UserBookDaoProvider.class, method = "listMyFavourites")
    List<UserBook> listMyFavourites(UserBook userBook);
}
