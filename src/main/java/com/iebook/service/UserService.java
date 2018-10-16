package com.iebook.service;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.User;

public interface UserService {
    User login (User usr);
    /**
     * @deprecation 查询所有用户
     *
     * @param:
     * @return:
     */
    PageInfo listUser(int page, int size);

    /**
     * @deprecation: 通过用户查询单一用户
     *
     * @param:
     * @return:
     */
    User getUser(User user);

    /**
     * @deprecation: 通过条件查询用户列表
     *
     * @param:
     * @return:
     */
    PageInfo listUserByCondition (User user) ;

    /**
     * @deprecation: 保存用户
     *
     * @param:
     * @return:
     */
    boolean saveOrUpdateUser (User user) ;

}
