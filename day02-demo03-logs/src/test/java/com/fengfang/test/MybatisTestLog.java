package com.fengfang.test;

import com.fengfang.dao.IUserDao;
import com.fengfang.domain.User;
import com.fengfang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
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
}
