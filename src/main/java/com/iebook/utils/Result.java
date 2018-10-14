package com.iebook.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 返回的结果集
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 返回的消息
     */
    private String message;

    /**
     * 返回的code值
     */
    private Integer code;

    /**
     * 结果集合
     */
    private List data;

}
