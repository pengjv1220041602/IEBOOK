package com.iebook.dao;

import com.iebook.dao.provider.UserDaoProvider;
import com.iebook.entry.User;
import com.iebook.utils.Constants;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from tuser")
    List<User> listUser();

    @Select("select * from tuser where tuser.id = #{id} and tuser.flag = " + Constants.Code.EXIST_CODE)
    User getUser(User user);

    @SelectProvider(type = UserDaoProvider.class, method = "listUserByCondition")
    List<User> listUserByCondition(User user);

    @Insert("insert into tuser (id, name, power,createdate, updatedate, flag) value (#{id}, #{name}, #{power}, #{createdate}, #{updatedate}, #{flag})")
    int saveUser (User user) ;

    @UpdateProvider(type = UserDaoProvider.class, method = "updateUser")
    int updateUser (User user);
}
