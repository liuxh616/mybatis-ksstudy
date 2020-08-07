package com.fengfang.test;

import com.fengfang.dao.IUserDao;
import com.fengfang.domain.User;
import com.fengfang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 10:07
 **/
public class AnnoTest {

    @Test
    public void  testFindAll(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testFindById(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(2);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testAddUser(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = new User();
        user.setUserName("测试名称");
        user.setUserPassword("123445");
        userDao.addUser(user);
        //不用提交事务，原因是创建的session设置了自动提交事务
        session.close();
    }

    @Test
    public void testUpdateUser(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(2);
        user.setUserName(user.getUserName()+"_测试修xx改");
        userDao.updateUser(user);
        session.close();
    }
}
