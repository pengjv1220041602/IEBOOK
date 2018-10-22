package com.iebook.service.impl;

import com.iebook.dao.LogDao;
import com.iebook.entry.Log;
import com.iebook.service.LogService;
import com.iebook.utils.Constants;
import com.iebook.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    public Map<String, Object> getPopularBooks (Log log) {
        Map<String, Object> result = new LinkedHashMap<>();

        log.setLimit(3);
        // 得到受欢迎的书
        List<Log> popularBooks = logDao.getPopularBooks(log);
        // 统计在线和下载量
        List<String> bookids = popularBooks.stream().map(Log::getBookid).collect(Collectors.toList());
        if (bookids == null || bookids.size() < 1){
            return null;
        }
        Map<String, List<String>> mapParms = new HashMap<>();
        mapParms.put("bookids", bookids);


        // 返回的集合变量
        List<String> bookcountsdown = new ArrayList<>();
        List<String> bookcountsline = new ArrayList<>();
        List<String> bookdates = new ArrayList<>();
        List<String> booknames = new ArrayList<>();

        List<Log> logs = logDao.countBookDownAndOnline(mapParms);
        Map<String, List<List<String>>> mapcount = new LinkedHashMap<>();
        for (Log tempLog : logs) {
            if (!bookdates.contains(tempLog.getShowdate())) {
                bookdates.add(tempLog.getShowdate());
            }
        }
        for (Log tempLog : logs) {
            if (!mapcount.containsKey(tempLog.getBookid())) {
                ArrayList<String> listdown = new ArrayList<>();
                ArrayList<String> listline = new ArrayList<>();
                for (int i=0; i < bookdates.size(); i++) {
                    listdown.add("0");
                    listline.add("0");
                }
                if (tempLog.getLineordown() == Constants.ONLINE_DOWN.DOWN) {
                    listdown.set(bookdates.indexOf(tempLog.getShowdate()), String.valueOf(tempLog.getCount()));
                } else {
                    listline.set(bookdates.indexOf(tempLog.getShowdate()), String.valueOf(tempLog.getCount()));
                }
                booknames.add(tempLog.getBookname());
                List<List<String>> ls = new ArrayList<>();
                ls.add(booknames);
                ls.add(listdown);
                ls.add(listline);
                mapcount.put(tempLog.getBookid(), ls);
            } else {
                List<List<String>> lists = mapcount.get(tempLog.getBookid());
                if (tempLog.getLineordown() == Constants.ONLINE_DOWN.DOWN) {
                    lists.get(1).set(bookdates.indexOf(tempLog.getShowdate()), String.valueOf(tempLog.getCount()));
                } else {
                    lists.get(2).set(bookdates.indexOf(tempLog.getShowdate()), String.valueOf(tempLog.getCount()));
                }
                mapcount.put(tempLog.getBookid(), lists);
            }

        }
        result.put("booknames", booknames);
        result.put("bookcount", mapcount);
        result.put("bookdates", bookdates);
        return result;
    }
}
