package com.iebook.entry;

import com.iebook.entry.page.Page;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:14
 * @Version 1.0
 * @Description:
 */
@Data
@ToString
public class Book extends Page<Book> {
    private String id;
    private String name;
    private Kind kind;
    private String isbn;
    private String path;
    private String picpath;
    private String detail;
    private String examine;
    private String examineuid;
    private Integer downcount;
    private Integer onlinecount;
    private String author;
    private Date createdate;
    private Date updatedate;
    private Integer flag;
}
