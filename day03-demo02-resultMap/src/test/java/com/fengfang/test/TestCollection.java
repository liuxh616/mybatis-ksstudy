package com.fengfang.test;

import com.fengfang.dao.IStudentDao;
import com.fengfang.dao.ITeacherDao;
import com.fengfang.domain.Student;
import com.fengfang.domain.Teacher;
import com.fengfang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 11:34
 **/
public class TestCollection {
    @Test
    public void testFindAll(){
        SqlSession session = MybatisUtils.getSqlSession();
        ITeacherDao teacherDao = session.getMapper(ITeacherDao.class);
        List<Teacher> teacherList = teacherDao.findAll();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        session.close();
    }

    @Test
    public void testFindALl2()
    {
        SqlSession session = MybatisUtils.getSqlSession();
        ITeacherDao teacherDao = session.getMapper(ITeacherDao.class);
        List<Teacher> teacherList = teacherDao.findAll2();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        session.close();
    }

    @Test
    public void testfindStuByTid()
    {
        SqlSession session = MybatisUtils.getSqlSession();
        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        List<Student> studentList = studentDao.findStuByTid(1);
        for (Student student : studentList) {
            System.out.println(student);
        }
        session.close();

    }

}
