package com.iebook.dao;

import com.iebook.entry.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select id, name from user where id = #{id}")
    User getUser(@Param("id") String id);
}
