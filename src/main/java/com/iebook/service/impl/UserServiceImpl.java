package com.iebook.service.impl;

import com.iebook.dao.UserDao;
import com.iebook.entry.User;
import com.iebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }
}
