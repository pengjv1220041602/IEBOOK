package com.iebook.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class UserBook {
    private String bookid;
    private String userid;
    private int likecount;
    private int hatecount;
    private int favourite;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updatedate;
    private int flag;
}
