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
     * 根据条件查询
     * @return
     */
    public List<Blog> findAllIf(Map<String,Object> map);

    /**
     * 根据代码片断来查询
     * @param map
     * @return
     */
    public List<Blog> findAllRefId(Map map);
    /**
     *
     * @param map
     * @return
     */
    public List<Blog> findAllLike(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    public List<Blog> findAllForeach(Map map);
    /**
     * 写入数据
     * @param blog
     * @return
     */
    public int addBlog(Blog blog);

    /**
     * 更新博客
     * @param map
     * @return
     */
    public int updateBlog(Map map);

}
