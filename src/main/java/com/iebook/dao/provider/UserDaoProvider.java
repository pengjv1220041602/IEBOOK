package com.iebook.dao.provider;

import com.iebook.entry.User;
import com.iebook.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Set;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001513:47
 * @Version 1.0
 * @Description:
 */
public class UserDaoProvider {
    public String listUserByCondition (User user) {
       final String sql = new SQL() {
            {
                SELECT("*");
                FROM("tuser");
                WHERE("tuser.flag = " + Constants.Code.EXIST_CODE);
                if (StringUtils.isNotBlank(user.getName())) {
                    AND();
                    WHERE("tuser.name=#{name}");
                }
            }
        }.toString();
        return sql;
    }

    public String updateUser (User user) {
        final String sql = new SQL() {
            {
                UPDATE("tuser");
                if (StringUtils.isNotBlank(user.getName())) {
                    SET("tuser.`name` = #{name}");
                }
                if (StringUtils.isNotBlank(user.getPassword())) {
                    SET("tuser.password = #{password}");
                }
                if (user.getPower() != null && (user.getPower() == Constants.PowerCode.ADMIN_CODE || user.getPower() == Constants.PowerCode.USER_CODE)) {
                    SET("power = #{power}" );
                }
                if (user.getEmail() != null && user.getEmail() != null) {
                    SET("email = #{email}");
                }
                if (user.getFlag() != null && (user.getFlag() == Constants.Code.EXIST_CODE || user.getFlag() == Constants.Code.NO_EXIST_CODE)) {
                    SET("flag = #{flag}" );
                }
                if (user.getPhoto() != null) {
                    SET("photo = #{photo}" );
                }
                SET("updatedate = #{updatedate}");
                WHERE("tuser.id = #{id}");
            }
        }.toString();
        return sql;
    }
}
