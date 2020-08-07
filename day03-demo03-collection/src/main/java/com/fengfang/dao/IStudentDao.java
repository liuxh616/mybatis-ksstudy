package com.fengfang.dao;

import com.fengfang.domain.Student;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 11:29
 **/
public interface IStudentDao {
    /**
     * 使用子查询方法
     * @return
     */
    public List<Student> findAll();

    /**
     * 使用结果查询方法
     * @return
     */
    public List<Student> findAll2();
}
