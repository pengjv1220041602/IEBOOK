package com.iebook.service.impl;

import com.iebook.entry.Book;
import com.iebook.entry.Kind;
import com.iebook.service.KindService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:57
 * @Version 1.0
 * @Description:
 */
@Service
public class KindServiceImpl implements KindService {

    @Override
    public List<Book> listBookByKind(Kind kind) {
        return null;
    }

    @Override
    public List<Kind> listKind() {
        return null;
    }

    @Override
    public boolean saveOrUpdateKind(Kind kind) {
        return true;
    }

}
