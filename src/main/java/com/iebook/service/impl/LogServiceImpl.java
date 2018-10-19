package com.iebook.service.impl;

import com.iebook.dao.LogDao;
import com.iebook.entry.Log;
import com.iebook.service.LogService;
import com.iebook.utils.Constants;
import com.iebook.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List listLogsByCondition(Log log){
        List<Log> logs = logDao.listLogsByCondition(log);
        return logs;
    }

    @Override
    public List<Log> getPopularBooks (Log log) {
        // 得到受欢迎的书
        List<Log> popularBooks = logDao.getPopularBooks(log);
        // 统计在线和下载量
        List<String> bookids = popularBooks.stream().map(Log::getBookid).collect(Collectors.toList());
        List<Log> logs = logDao.countBookDownAndOnline(bookids);
        return logs;
    }
}
