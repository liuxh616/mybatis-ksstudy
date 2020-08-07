package com.fengfang.domain;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 11:27
 **/
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> studentList;
}
