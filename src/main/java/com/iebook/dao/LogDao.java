package com.iebook.dao;

import com.iebook.dao.provider.LogDaoProvider;
import com.iebook.entry.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface LogDao {
    @Insert("insert  into  tlog (id, bookid, lineordown, flag, createdate) values (#{id}, #{bookid}, #{lineordown}, 1, #{createdate})")
    int saveLog(Log log);

    @SelectProvider(type = LogDaoProvider.class, method = "listLogsByCondition")
    List<Log> listLogsByCondition (Log log) ;

    @SelectProvider(type = LogDaoProvider.class, method = "getPopularBooks")
    List<Log> getPopularBooks(Log log);

    @SelectProvider(type = LogDaoProvider.class, method = "countBookDownAndOnline")
    List<Log> countBookDownAndOnline(Log log);
}
