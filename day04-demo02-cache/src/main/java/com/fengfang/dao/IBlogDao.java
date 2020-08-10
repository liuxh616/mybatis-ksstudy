package com.fengfang.dao;

import com.fengfang.domain.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/7 15:47
 **/
public interface IBlogDao {

    /**
     *
     * @return
     */
    public List<Blog> findAll();

    /**
     *
     * @param id
     * @return
     */
    public Blog findById(String id);

    /**
     * 更新微博
     * @param map
     * @return
     */
    public int updateBlog(Map map);
}
