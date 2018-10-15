package com.iebook.entry;

import lombok.Data;
import lombok.ToString;

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
    private int flag;
}
