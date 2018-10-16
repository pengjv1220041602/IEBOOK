package com.iebook.dao.provider;

import com.iebook.entry.Kind;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class KindDaoProvider {

    public String updateKind (Kind kind) {
        String sql = new SQL(){
            {
                UPDATE("tkind");
                if (StringUtils.isNotBlank(kind.getName())) {
                    SET("name = #{name}");
                }
                if (StringUtils.isNotBlank(kind.getCreateuid())) {
                    SET("createuid = #{createuid}");
                }
                if (kind.getUpdatedate() != null) {
                    SET("updatedate = #{updatedate}");
                }
                if (kind.getFlag() != 0) {
                    SET("flag = #{flag}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
        return  sql;
    }
}
