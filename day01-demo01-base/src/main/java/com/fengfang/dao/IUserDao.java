package com.fengfang.dao;

import com.fengfang.domain.User;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/7/29 16:57
 **/
public interface IUserDao {
    /**
     * 查询所有用户数据
     * @return
     */
    List<User> findAll();

    /**
     * 根据Id查询用户数据
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     *
     * @param map
     * @return
     */
    List<User> findByIdMap(Map<String,Object> map);

    /**
     *
     * @param map
     */
    void addUserMap(Map<String,Object> map);

    /**
     *
     * @param value
     * @return
     */
    List<User> getUserLike(String value);
}
