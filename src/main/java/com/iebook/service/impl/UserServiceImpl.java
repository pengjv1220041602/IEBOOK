package com.iebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iebook.dao.UserDao;
import com.iebook.entry.User;
import com.iebook.service.UserService;
import com.iebook.utils.Constants;
import com.iebook.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login (User user) {
        return userDao.login(user);
    }

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
        user.setUpdatedate(new Date());
        if (StringUtils.isNotBlank(user.getId())) {
              return userDao.updateUser(user) > 0 ;
        }
        user.setCreatedate(new Date());
        user.setPower(Constants.PowerCode.USER_CODE);
        user.setFlag(Constants.Code.EXIST_CODE);
        user.setId(Utils.getUUID());
        return userDao.saveUser(user) > 0;
    }
}
