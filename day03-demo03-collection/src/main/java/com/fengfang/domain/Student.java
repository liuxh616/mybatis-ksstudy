package com.fengfang.domain;

import lombok.Data;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 11:26
 **/
@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}
