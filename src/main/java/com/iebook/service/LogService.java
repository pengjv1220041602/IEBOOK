package com.iebook.service;

import com.iebook.entry.Log;

import java.util.List;
import java.util.Map;

public interface LogService {

    boolean saveLog(Log log);

    List listLogsByCondition(Log log);

    Map<String, Object> getPopularBooks(Log log);

}
