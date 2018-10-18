package com.iebook.service.impl;

import com.iebook.dao.LogDao;
import com.iebook.entry.Log;
import com.iebook.service.LogService;
import com.iebook.utils.Constants;
import com.iebook.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public boolean saveLog(Log log) {
        log.setId(Utils.getUUID());
        log.setCreatedate(new Date());
        log.setFlag(Constants.Code.EXIST_CODE);
        return logDao.saveLog(log) > 0;
    }
}
