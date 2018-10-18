package com.iebook.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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
    private Integer lineordown;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    private Integer flag;
}
