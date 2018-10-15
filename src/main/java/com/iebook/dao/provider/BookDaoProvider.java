package com.iebook.dao.provider;

import com.iebook.entry.Book;
import com.iebook.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001516:18
 * @Version 1.0
 * @Description:
 */
public class BookDaoProvider {

    public String listBookByCondition (Book book) {
        String sql = new SQL () {
            {
                SELECT("select *");
                FROM("tbook");
                WHERE("flag = " + Constants.Code.EXIST_CODE);
                if (StringUtils.isNotBlank(book.getName())) {
                    AND();
                    WHERE("name like %#{name}%");
                }
                if (StringUtils.isNotBlank(book.getAuthor())) {
                    AND();
                    WHERE("author like %#{author}%");
                }
               /* if (book.getExamine() != null && book.getExamine() == Constants.ExamineCode.NO_PASS) {

                }*/
            }
        }.toString();
        return sql;
    }
}
