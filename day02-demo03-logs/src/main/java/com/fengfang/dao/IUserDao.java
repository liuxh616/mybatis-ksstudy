package com.fengfang.dao;

import com.fengfang.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    /**
     * 使用Limit分页查询
     * @param map
     * @return
     */
    List<User> findAllPages(Map<String,Integer> map);

    /**
     *
     * @return
     */
    List<User> findAllBowBounds();
}
