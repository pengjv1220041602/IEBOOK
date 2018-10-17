package com.iebook.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iebook.entry.page.Page;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:14
 * @Version 1.0
 * @Description:
 */
@Data
@ToString
public class Book {
    private String id;
    private String name;
    private Kind kind;
    private String isbn;
    private String path;
    private String picpath;
    private String detail;
    private Integer examine;
    private String examineuid;
    private String examinename;
    private Integer downcount;
    private Integer onlinecount;
    private String author;
    private String updateuid;
    private String updatename   ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updatedate;
    private Integer flag;
}
