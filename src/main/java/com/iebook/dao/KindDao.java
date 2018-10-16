package com.iebook.dao;

import com.iebook.dao.provider.KindDaoProvider;
import com.iebook.entry.Kind;
import com.iebook.utils.Constants;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001513:09
 * @Version 1.0
 * @Description:
 */
@Mapper
public interface KindDao {
    @Insert("insert  into tkind (id, name,createdate,updatedate, createuid, flag) values (#{id}, #{name},#{createdate}, #{updatedate}, #{createuid}, #{flag})")
    int saveKind (Kind kind);

    @UpdateProvider(type = KindDaoProvider.class, method = "updateKind")
    int updateKind(Kind kind);

    @Select("select * from tkind where flag = " + Constants.Code.EXIST_CODE)
    List<Kind> listKind ();

}
