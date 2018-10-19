package com.iebook.dao.provider;

import com.iebook.entry.Log;
import com.iebook.utils.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.security.KeyStore;
import java.util.Collections;
import java.util.List;

public class LogDaoProvider {

    public String listLogsByCondition (Log log) {
        String sql = new SQL(){
            {
                SELECT("COUNT(tlog.id) AS 'count', DATE_FORMAT(tlog.createdate,'%Y-%m-%d') AS 'showdate', tbook.name AS 'bookname'");
                FROM("tlog");
                LEFT_OUTER_JOIN("tbook");
                WHERE("flag = " + Constants.Code.EXIST_CODE);
                if (log.getStartdate() != null && log.getEnddate() != null) {
                    AND();
                    WHERE("createdate BETWEEN DATE_FORMAT(#{startdate}, '%Y-%m-%d') and DATE_FORMAT(#{enddate}, '%Y-%m-%d')");
                    GROUP_BY("logdate");
                } else if (log.getStartdate() != null) {
                    AND();
                    WHERE("createdate >= #{startdate}");
                } else if (log.getEnddate() != null) {
                    AND();
                    WHERE("createdate <= #{enddate}");
                }
                GROUP_BY("showdate, tlog.bookid");
                ORDER_BY("count DESC");
                if (log.getLimit() != null) {
                    WHERE("limit 0, #{limit}");
                }
            }
        }.toString();
        return sql;
    }

    public String getPopularBooks (Log log) {
        String sql = new SQL() {
            {
                SELECT("bookid, count(*) AS 'count', book.name AS 'bookname'");
                FROM("tlog log");
                LEFT_OUTER_JOIN("tbook book on book.id = log.bookid");
                WHERE("log.flag = "+ Constants.Code.EXIST_CODE + " and book.flag = " +Constants.Code.EXIST_CODE);
                if (log.getStartdate() != null && log.getEnddate() != null) {
                    AND();
                    WHERE("log.createdate between #{startdate} and #{enddate}");
                } else if (log.getStartdate()!=null) {
                    AND();
                    WHERE("createdate >= #{startdate}");
                } else if (log.getEnddate() != null){
                    AND();
                    WHERE("#{enddate} >= createdate");
                }
                GROUP_BY("bookid");
                WHERE(" order by count(*) DESC limit 0, #{limit}");
            }
        }.toString();
        return sql;
    }

    public String countBookDownAndOnline(List<String> bookids) {
        String sql = new SQL(){
            {
                selectBookEle();
                WHERE("flag = " + Constants.Code.EXIST_CODE);
                bookIdInIds();
                WHERE("group by bookid");
                WHERE("UNION ALL");
                selectBookEle();
                WHERE("flag = " + Constants.Code.EXIST_CODE);
                bookIdInIds();
                WHERE("group by bookid, createdate");
            }
            protected void selectBookEle() {
                SELECT("count(tlog.lineordown) AS 'count'");
                SELECT("DATE_FORMAT(tlog.createdate,'%Y-%m-%d') AS 'showdate'");
                SELECT("tbook.name AS bookname");
                FROM("tlog");
                LEFT_OUTER_JOIN("tbook on tlog.bookid = tbook.id");
            }

            protected void bookIdInIds(){
                if (bookids != null && bookids.size() > 0) {
                    WHERE("bookid in ( ");
                    for (int i = 0; i < bookids.size(); i++) {
                        if (i != bookids.size() - 1) {
                            WHERE(bookids.get(i) + ",");
                            continue;
                        }
                        WHERE(bookids.get(i));
                    }
                    WHERE(")");
                }
            }
        }.toString();
        return sql;
    }
}
