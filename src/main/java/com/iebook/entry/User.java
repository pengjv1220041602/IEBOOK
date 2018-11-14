package com.iebook.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iebook.entry.page.Page;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.pattern.PathPattern;

import java.util.Date;

@Data
@ToString
public class User extends Page<User> {
    private String code;
    private String photo;
    private MultipartFile phfile;
    private String id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Integer power;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updatedate;
    private Integer flag;
}
