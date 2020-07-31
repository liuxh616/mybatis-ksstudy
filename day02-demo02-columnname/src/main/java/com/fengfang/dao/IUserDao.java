package com.fengfang.dao;

import com.fengfang.domain.User;

import java.util.List;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/7/30 12:28
 **/
public interface IUserDao {
    /**
     * 查询所有用户数据
     * @return
     */
    List<User> findAll();
}
