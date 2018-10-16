package com.iebook.entry;

import com.iebook.entry.page.Page;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String createuid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedate;
    private int flag;
}
