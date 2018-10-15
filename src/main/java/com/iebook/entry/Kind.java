package com.iebook.entry;

import com.iebook.entry.page.Page;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:57
 * @Version 1.0
 * @Description:
 */
@Data
@ToString
public class Kind extends Page<Kind> {
    private String id;
    private String name;
    private Date createdate;
    private Date updatedate;
    private int flag;
}
