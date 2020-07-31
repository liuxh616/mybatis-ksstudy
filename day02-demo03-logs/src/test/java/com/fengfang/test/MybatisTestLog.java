package com.fengfang.test;

import com.fengfang.dao.IUserDao;
import com.fengfang.domain.User;
import com.fengfang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/7/30 12:30
 **/
public class MybatisTestLog {

    static Logger logger = Logger.getLogger(MybatisTestLog.class);
    @Test
    public void testFindAll(){
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testLog4j(){
        logger.info("测试info内容");
        logger.debug("进入了log4j的debug内容");
        logger.error("进入了log4j的error内容");
    }

    @Test
    public void testFindAllPages()
    {
        SqlSession session = MybatisUtils.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = userDao.findAllPages(map);
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testfindAllBowBounds(){
        SqlSession session = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0,2);
        List<User> userList =session.selectList("com.fengfang.dao.IUserDao.findAllBowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }
}
