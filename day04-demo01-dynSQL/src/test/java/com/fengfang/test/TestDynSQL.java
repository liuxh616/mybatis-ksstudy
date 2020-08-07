package com.fengfang.test;

import com.fengfang.dao.IBlogDao;
import com.fengfang.domain.Blog;
import com.fengfang.utils.IDutils;
import com.fengfang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/7 15:48
 **/
public class TestDynSQL {
  @Test
    public void testGetId(){
      System.out.println(IDutils.getId());
  }

  @Test
  public void testAddBlog(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    Blog blog = new Blog();
    blog.setId(IDutils.getId());
    blog.setTitle("mybatis 多简单呀！");
    blog.setAuthor("aaron");
    blog.setCreateTime(new Date());
    blogDao.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("spring 多简单呀！");
    blog.setAuthor("aaron");
    blogDao.addBlog(blog);


    blog.setId(IDutils.getId());
    blog.setTitle("springboot 多简单呀！");
    blog.setAuthor("aaron");
    blogDao.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("微服务 多简单呀！");
    blog.setAuthor("aaron");
    blogDao.addBlog(blog);

    session.commit();
    session.close();
  }

  @Test
  public void  testFindAll(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    List<Blog> blogList = blogDao.findAll();
    for (Blog blog : blogList) {
      System.out.println(blog);
    }
    session.close();
  }

  @Test
  public void  testFindAllIf(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    Map map = new HashMap();
    map.put("views",8000);
    List<Blog> blogList = blogDao.findAllIf(map);
    for (Blog blog : blogList) {
      System.out.println(blog);
    }
    session.close();
  }
}
