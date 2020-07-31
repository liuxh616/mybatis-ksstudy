package com.fengfang.test;

import com.fengfang.dao.IUserDao;
import com.fengfang.domain.User;
import com.fengfang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/7/30 12:30
 **/
public class MybatisTestResultMap {
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
}
