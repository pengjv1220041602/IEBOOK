package com.iebook.dao.provider;

import com.iebook.entry.User;
import com.iebook.entry.UserBook;
import com.iebook.utils.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author ZhPJ
 * @Date 2018/10/23 002315:00
 * @Version 1.0
 * @Description:
 */
public class UserBookDaoProvider {
    public String saveUserBook(UserBook userBook){
        String sql = new SQL() {
            {
                INSERT_INTO("tuserbook");
                VALUES("bookid", "#{bookid}");
                VALUES("userid", "#{userid}");
                VALUES("favourite", "#{favourite}");
                VALUES("flag", String.valueOf(Constants.Code.EXIST_CODE));
            }
        }.toString();
        return sql;
    }

    public String updateUserBook(UserBook userBook){
        String sql = new SQL(){
            {
                UPDATE("tuserbook");
                SET("favourite = #{favourite}");
                WHERE("bookid = #{bookid} and userid=#{userid} and flag = " + Constants.Code.EXIST_CODE);
            }
        }.toString();
        return sql;
    }

    public String listMyFavourites (UserBook userBook) {
        String sql = new SQL(){
            {
                SELECT("favourite ,tuserbook.bookid AS bookid ,book.name AS 'book.name', book.author AS 'book.author', book.detail AS 'book.detail' ,kind.name AS kindname");
                FROM("tuserbook left join tbook book on book.id = tuserbook.bookid left join tkind kind on kind.id = book.kindid");
                WHERE("tuserbook.userid = #{userid} and tuserbook.flag = " + Constants.Code.EXIST_CODE +" and book.flag = " + Constants.Code.EXIST_CODE + " and favourite = " + Constants.FavouriteCode.FAVOURITE_CODE);
            }
        }.toString();
        return sql;
    }
}
