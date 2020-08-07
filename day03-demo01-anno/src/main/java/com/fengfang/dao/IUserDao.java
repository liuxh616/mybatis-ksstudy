package com.fengfang.dao;

import com.fengfang.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select id,name as userName,pwd as userPassword from user")
    List<User> findAll();

    @Select("select id,name as userName,pwd as userPassword from user where id = #{id}")
    User findById(@Param("id") int id);
    @Insert("insert into user(name,pwd) values(#{userName},#{userPassword})")
    int addUser(User user);

    /**
     *
     * @param user
     * @return
     */
    @Update("update user set name=#{userName},pwd=#{userPassword} where id=#{id}")
    int updateUser(User user);
}
