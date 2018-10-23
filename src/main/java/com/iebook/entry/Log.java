package com.iebook.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Log {
    public Log (String bookid, Integer lineordown) {
        this.bookid = bookid;
        this.lineordown = lineordown;
    }
    private String id;
    private String bookid;
    private String bookname;
    private Integer lineordown;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    private String showdate;
    private Integer flag;
    private String startdate;
    private String enddate;

    private List<String> bookids;
    private int count;
    private Integer limit;
}
