package com.iebook.service.impl;

import com.iebook.dao.KindDao;
import com.iebook.entry.Book;
import com.iebook.entry.Kind;
import com.iebook.service.KindService;
import com.iebook.utils.Constants;
import com.iebook.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:57
 * @Version 1.0
 * @Description:
 */
@Service
public class KindServiceImpl implements KindService {

    @Autowired
    private KindDao kindDao;

    @Override
    public List<Book> listBookByKind(Kind kind) {
        return null;
    }

    @Override
    public List<Kind> listKind() {
        return kindDao.listKind();
    }

    @Override
    public boolean saveOrUpdateKind(Kind kind) {
        int count = 0;
        kind.setUpdatedate(new Date());
        kind.setCreateuid("111111111111");
        if (StringUtils.isBlank(kind.getId())) {
            kind.setId(Utils.getUUID());
            kind.setCreatedate(new Date());
            kind.setFlag(Constants.Code.EXIST_CODE);
            count = kindDao.saveKind(kind);
        } else {
            count = kindDao.updateKind(kind);
        }
        return count > 0 ;
    }

}
