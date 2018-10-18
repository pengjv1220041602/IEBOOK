package com.iebook.dao.provider;

import com.iebook.entry.Log;
import com.iebook.utils.Constants;
import org.apache.ibatis.jdbc.SQL;

public class LogDaoProvider {

    public String listLogsByCondition (Log log) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM("tlog");
                WHERE("flag = " + Constants.Code.EXIST_CODE);
            }
        }.toString();
        return sql;
    }

}
