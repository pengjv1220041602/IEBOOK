package com.iebook.dao.provider;

import com.iebook.entry.Log;
import com.iebook.utils.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.security.KeyStore;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
                    WHERE("log.createdate >= #{startdate}");
                } else if (log.getEnddate() != null){
                    AND();
                    WHERE("#{enddate} >= log.createdate");
                }
                GROUP_BY("bookid order by count DESC limit 0, #{limit} ");
//                WHERE(" ");
            }
        }.toString();
        System.out.println(sql+"=========================");
        return sql;
    }

    public String countBookDownAndOnline(Log log) {
        List<String> bookids = log.getBookids();
        String sql = new SQL(){
            {
                String select = "";
                select += selectBookEle(true);
                select += " where tlog.flag = " + Constants.Code.EXIST_CODE + " AND lineordown = 1" + selectBookDate(log);
                select += bookIdInIds(bookids);
                select += " group by showdate,  tbook.id";
                select += " UNION ALL ";
                select += selectBookEle(false);
                select += " where tlog.flag = " + Constants.Code.EXIST_CODE +" AND lineordown = 2" + selectBookDate(log);
                select += bookIdInIds(bookids);
                select += " group by showdate,tbook.id";
                SELECT(select);
            }

            protected String selectBookDate (Log log) {
                if (log.getStartdate() != null && log.getEnddate() != null) {
                    return " and tlog.createdate between #{startdate} and #{enddate}";
                } else if (log.getStartdate() != null) {
                    return " and tlog.createdate >= #{startdate}";
                } else if (log.getEnddate() != null){
                    return " and log.createdate  <= #{enddata}";
                }
                return "";
            }

            protected String selectBookEle(boolean flag) {
                String select = flag ? "" : " select ";
                select += "count(tlog.lineordown) AS 'count', "+(flag ? "1" : "2")+" AS lineordown,";
                select += "DATE_FORMAT(tlog.createdate,'%Y-%m-%d') AS 'showdate',";
                select += "tbook.`name` AS bookname, tbook.id AS bookid";
                select += " from tlog left join tbook on tlog.bookid = tbook.`id`";
                return select;
            }

            protected String bookIdInIds(List<String> bookids){
                String sql = "";
                if (bookids != null && bookids.size() > 0) {
                    sql += " and bookid in ( ";
                    for (int i = 0; i < bookids.size(); i++) {
                        sql += "'" + bookids.get(i) + "'";
                        if (i != bookids.size() - 1) {
                            sql += ",";
                            continue;
                        }
                    }
                    sql += ")";
                }
                return sql;
            }
        }.toString();
        System.out.println(sql);
        return sql;
    }
}
