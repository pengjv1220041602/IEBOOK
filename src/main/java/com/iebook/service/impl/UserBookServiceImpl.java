package com.iebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iebook.dao.UserBookDao;
import com.iebook.entry.UserBook;
import com.iebook.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/23 002315:42
 * @Version 1.0
 * @Description:
 */
@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    private UserBookDao userBookDao;

    @Override
    public boolean saveOrUpdateUserBook(UserBook userBook) {
        UserBook ubid = userBookDao.getUserBook(userBook);
        if (ubid != null) {
            return userBookDao.updateUserBook(userBook) > 0;
        }
        return userBookDao.saveUserBook(userBook) > 0;
    }
    @Override
    public PageInfo listMyFavourites(int page, int size, UserBook userBook) {
        PageHelper.startPage(page, size);
        return new PageInfo( userBookDao.listMyFavourites(userBook));
    }
}
