package com.fengfang.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/7 15:44
 **/
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
