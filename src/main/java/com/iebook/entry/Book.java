package com.iebook.entry;

import lombok.Data;
import lombok.ToString;

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
    private String isbn;
    private String path;
    private String picpath;
    private String detail;
    private String examine;
    private String examineuid;
    private Integer downcount;
    private Integer onlinecount;
    private String author;
    private int flag;
}
