package com.iebook.entry.page;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001513:40
 * @Version 1.0
 * @Description:
 */
@Data
@ToString
public class Page<T> {
    private int page;
    private int size;
    private List<T> datas;
}
