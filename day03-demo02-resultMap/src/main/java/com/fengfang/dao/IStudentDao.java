package com.fengfang.dao;

import com.fengfang.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 11:29
 **/
public interface IStudentDao {
    @Select("select id as sid,name as sname from student where tid=#{tid}")
    public List<Student> findStuByTid(@Param("tid") int tid);
}
