package com.fengfang.dao;

import com.fengfang.domain.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 11:29
 **/
public interface ITeacherDao {

    public List<Teacher> findAll();

    public List<Teacher> findAll2();

}
