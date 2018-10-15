package com.iebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iebook.dao.UserDao;
import com.iebook.entry.User;
import com.iebook.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo listUser(int page, int size) {
        PageHelper.startPage(page, size);
        return new PageInfo(userDao.listUser());
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public PageInfo listUserByCondition(User user) {
        PageHelper.startPage(user.getPage(), user.getSize());
        return new PageInfo(userDao.listUserByCondition(user));
    }

    @Override
    @Transactional
    public boolean saveOrUpdateUser(User user) {
        if (StringUtils.isNotBlank(user.getId())) {
              return userDao.updateUser(user) > 0 ;
        }
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return userDao.saveUser(user) > 0;
    }
}
