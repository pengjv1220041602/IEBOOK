package com.iebook.dao.provider;

import com.iebook.entry.Book;
import com.iebook.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.jdbc.SQL;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001516:18
 * @Version 1.0
 * @Description:
 */
public class BookDaoProvider {

    public String getBook (Book book) {
        String sql = new SQL() {
            {
                SELECT("book.id AS id, book.`name` AS name, tkind.id AS 'kind.id', tkind.name AS 'kind.name', isbn, path");
                SELECT("picpath, detail, examine, user1.name AS examinename", "downcount, onlinecount");
                SELECT("author,user2.id AS updateuid, user2.name AS updatename, book.createdate AS createdate, book.updatedate AS updatedate");
                FROM("tbook book");
                LEFT_OUTER_JOIN("tuser user1 on book.examineuid = user1.id"
                        , "tuser user2 on book.updateuid = user2.id"
                        , "tkind on tkind.id = book.kindid");
                WHERE("book.id = #{id}" );
                AND();
                WHERE("book.flag = "+Constants.Code.EXIST_CODE);
            }
        }.toString();
        return sql;
    }

    public String listBook (Book book) {
        String sql = new SQL() {
            {
                SELECT("book.id AS id, book.`name` AS name, tkind.id AS 'kind.id', tkind.name AS 'kind.name', isbn, path");
                SELECT("picpath, detail, examine, user1.name AS examinename", "downcount, onlinecount");
                SELECT("author,user2.id AS updateuid, user2.name AS updatename, book.createdate AS createdate, book.updatedate AS updatedate");
                FROM("tbook book");
                LEFT_OUTER_JOIN("tuser user1 on book.examineuid = user1.id"
                        , "tuser user2 on book.updateuid = user2.id"
                        , "tkind on tkind.id = book.kindid");
                WHERE("book.flag = " + Constants.Code.EXIST_CODE);
                AND();
                WHERE("examine = " + Constants.ExamineCode.PASS);
                ORDER_BY("book.updatedate DESC");
            }
        }.toString();
        return sql;
    }

    public String listBookByCondition (Book book) {
        String sql = new SQL () {
            {
                SELECT("book.id AS id, book.`name` AS name, tkind.id AS 'kind.id', tkind.name AS 'kind.name', isbn, path");
                SELECT("picpath, detail, examine, user1.name AS examinename", "downcount, onlinecount");
                SELECT("author,user2.id AS updateuid, user2.name AS updatename, book.createdate AS createdate, book.updatedate AS updatedate");
                FROM("tbook book");
                LEFT_OUTER_JOIN("tuser user1 on book.examineuid = user1.id"
                        , "tuser user2 on book.updateuid = user2.id"
                        , "tkind on tkind.id = book.kindid");
                WHERE("book.flag = " + Constants.Code.EXIST_CODE);
                if (StringUtils.isNotBlank(book.getName())) {
                    AND();
                    WHERE("name like %#{name}%");
                }
                if (StringUtils.isNotBlank(book.getAuthor())) {
                    AND();
                    WHERE("author like %#{author}%");
                }
                if (book.getKind() != null && StringUtils.isNotBlank(book.getKind().getId())) {
                    AND();
                    WHERE("tkind.id = #{kind.id}");
                }
                if (book.getExamine() != null && book.getExamine() == Constants.ExamineCode.NO_AND_PASS) {
                    AND();
                    WHERE("examine = "+Constants.ExamineCode.NO_PASS+" or examine = "+Constants.ExamineCode.WAIT_EXAMINE);
                } else if (book.getExamine() != null) {
                    AND();
                    WHERE("examine = #{examine}");
                }
                if (StringUtils.isNotBlank(book.getUpdateuid())) {
                    AND();
                    WHERE("book.updateuid = #{updateuid}");
                }
                ORDER_BY("book.updatedate DESC");
            }
        }.toString();
        return sql;
    }

    public String saveBook (Book book) {
        String sql = new SQL() {
            {
                INSERT_INTO("tbook");
                VALUES("id", "#{id}");
                VALUES("name", "#{name}");
                VALUES("kindid", "#{kind.id}");
                VALUES("path", "#{path}");
                VALUES("picpath", "#{picpath}");
                VALUES("examine", "#{examine}");
                VALUES("examineuid", "#{examineuid}");
                VALUES("updateuid", "#{updateuid}");
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
                SET("updatedate = #{updatedate}");
                SET("updateuid = #{updateuid}");
                if (StringUtils.isNotBlank(book.getName())) {
                    SET("name = #{name}");
                }
                if (book.getKind() != null && StringUtils.isNotBlank(book.getKind().getId())) {
                    SET("kindid = #{kind.id}");
                }
                if (StringUtils.isNotBlank(book.getPath())) {
                    SET("path = #{path}");
                }
                if (StringUtils.isNotBlank(book.getPicpath())) {
                    SET("picpath = #{picpath}");
                }
                if (StringUtils.isNotBlank(book.getDetail())) {
                    SET("detail = #{detail}");
                }
                if (book.getExamine() != null) {
                    SET("examine = #{examine}");
                    SET("examineuid = #{examineuid}");
                }
                if (book.getDowncount() != null &&  book.getDowncount() == 1) {
                    SET("downcount = downcount + 1");
                }
                if (book.getOnlinecount() != null && book.getOnlinecount() == 1) {
                    SET("onlinecount = onlinecount + 1");
                }
                if (StringUtils.isNotBlank(book.getAuthor())) {
                    SET("author = #{author}");
                }
                if (book.getFlag() != null) {
                    SET("flag = #{flag}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
        return sql;
    }
}
