package com.iebook.service;

import com.iebook.entry.Book;
import com.iebook.entry.Kind;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:57
 * @Version 1.0
 * @Description:
 */
public interface KindService {
    /**
     * @deprecation: 通过类型编号获取图书列表或通过类型名称查询
     *
     * @param: Kind
     * @return: 图书列表
     */
    List<Book> listBookByKind (Kind kind);

    /**
     * @deprecation: 列出所有分类
     *
     * @param:
     * @return:
     */
    List<Kind> listKind ();

    /**
     * @deprecation: 保存分类
     *
     * @param:
     * @return:
     */
    boolean saveOrUpdateKind (Kind kind);
}
