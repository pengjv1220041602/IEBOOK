package com.iebook.service;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.UserBook;

/**
 * @Author ZhPJ
 * @Date 2018/10/23 002315:41
 * @Version 1.0
 * @Description:
 */
public interface UserBookService {
     boolean saveOrUpdateUserBook(UserBook userBook);
     PageInfo listMyFavourites(int page, int size, UserBook userBook);
}
