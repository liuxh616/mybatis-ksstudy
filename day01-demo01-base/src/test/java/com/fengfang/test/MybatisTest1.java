package com.fengfang.test;

import com.fengfang.dao.IUserDao;
import com.fengfang.domain.User;
import com.fengfang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/7/29 17:07
 **/
public class MybatisTest1 {
    @Test
    public void testFindAll(){

        SqlSession session = null;
        try {
            session = MybatisUtils.getSqlSession();
            IUserDao dao = session.getMapper(IUserDao.class);
            List<User> userList = dao.findAll();
            for(User user :userList){
                System.out.println(user);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Test
    public void testFindById(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(10);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testFindByIdMap(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","%测试%");
        List<User> users = userDao.findByIdMap(map);
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testGetUserLike(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);

        List<User> users = userDao.getUserLike("测试");
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testAddUser(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = new User();
        user.setId(22);
        user.setName("刘钥");
        user.setPwd("123456");
        userDao.addUser(user);
        //提交事务
        session.commit();
        //关闭session
        session.close();
    }

    @Test
    public void testUpdateUser(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(14);
        System.out.println(user);
        user.setName("测试名称");
        user.setPwd("1234879");
        userDao.updateUser(user);
        session.commit();
        session.close();
        System.out.println(user);
    }

    @Test
    public void testDeleteUser(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        userDao.deleteUser(9);
        session.commit();
        session.close();
    }

    @Test
    public void testAddUserMap(){

        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userName","测试Map名称");
        map.put("userPwd","测试密码");
        userDao.addUserMap(map);
        //提交事务
        session.commit();
        //关闭session
        session.close();
    }
}
