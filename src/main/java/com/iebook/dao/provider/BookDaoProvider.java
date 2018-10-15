package com.iebook.dao.provider;

import com.iebook.entry.Book;
import com.iebook.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Insert;
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
                if (book.getExamine() != null) {
                    AND();
                    WHERE("examine = #{examine}");
                }
            }
        }.toString();
        return sql;
    }

    public String saveBook (Book book) {
        String sql = new SQL() {
            {
                INSERT_INTO("tbook");
                VALUES("name", "#{name}");
                VALUES("kindid", "#{kindid}");
                VALUES("path", "#{path}");
                VALUES("picpath", "#{picpath}");
                VALUES("examine", "#{examine}");
                VALUES("examineuid", "#{examineuid}");
                if (book.getDowncount() != null) {
                    VALUES("downcount", "#{downcount}");
                } else {
                    VALUES("downcount", "0");
                }
                if (StringUtils.isNotBlank(book.getDetail())) {
                    VALUES("detail", "#{detail}");
                }
                if (book.getOnlinecount() == null) {
                    VALUES("onlinecount", "0");
                } else {
                    VALUES("onlinecount", "#{onlinecount}");
                }
                if (StringUtils.isNotBlank(book.getAuthor())) {
                    VALUES("author", "#{author}");
                }
                VALUES("createdate", "#{createdate}");
                VALUES("updatedate", "#{updatedate}");
                VALUES("flag", String.valueOf(Constants.Code.EXIST_CODE));
            }
        }.toString();
        return sql;
    }

    public String updateBook (Book book) {
        String sql = new SQL() {
            {
                UPDATE("tbook");
                SET("updatedate", "#{updatedate}");
                if (StringUtils.isNotBlank(book.getName())) {
                    SET("name = #{name}");
                }
                if (StringUtils.isNotBlank(book.getKind().getId())) {
                    SET("kindid", "#{kind.id}");
                }
                if (StringUtils.isNotBlank(book.getPath())) {
                    SET("path", "#{path}");
                }
                if (StringUtils.isNotBlank(book.getPicpath())) {
                    SET("picpath", "#{picpath}");
                }
                if (StringUtils.isNotBlank(book.getDetail())) {
                    SET("detail", "#{detail}");
                }
                if (book.getExamine() != null) {
                    SET("examine", "#{examine}");
                    SET("examineuid", "#{examineuid}");
                }
                if (book.getDowncount() == 1) {
                    SET("downcount", "downcount + 1");
                }
                if (book.getOnlinecount() == 1) {
                    SET("onlinecount", "onlinecount + 1");
                }
                if (StringUtils.isNotBlank(book.getAuthor())) {
                    SET("author", "#{author}");
                }
                if (book.getFlag() != null) {
                    SET("flag", "#{flag}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
        return sql;
    }
}
