package com.iebook.entry;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private String id;
    private String name;
    private Integer power;
    private int flag;
}
