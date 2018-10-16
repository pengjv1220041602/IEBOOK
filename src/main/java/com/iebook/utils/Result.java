package com.iebook.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 返回的结果集
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    public Result (String message, Integer code,boolean success, List datas) {
        this.message = message;
        this.code = code;
        this.success = success;
        this.datas = datas;
    }

    public Result (String message, Integer code, boolean success, Object data) {
        this.message = message;
        this.code = code;
        this.success = success;
        this.data = data;
    }

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
    private List datas;

    /**
     * 返回一个单体对象
     */
    private Object data;

    /**
     * 成功或者失败
     */
    private boolean success;


}
