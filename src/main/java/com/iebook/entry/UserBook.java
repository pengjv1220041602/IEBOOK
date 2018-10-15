package com.iebook.entry;

import com.iebook.entry.page.Page;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:17
 * @Version 1.0
 * @Description:
 */
@Data
@ToString
public class UserBook extends Page<UserBook> {
    private String bookid;
    private String userid;
    private int likecount;
    private int hatecount;
    private int favourite;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedate;
    private int flag;
}
