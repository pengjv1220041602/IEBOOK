package com.iebook.service;

import com.iebook.entry.Log;

import java.util.List;

public interface LogService {
    boolean saveLog(Log log);
    List listLogsByCondition(Log log);

    List<Log> getPopularBooks(Log log);

}
