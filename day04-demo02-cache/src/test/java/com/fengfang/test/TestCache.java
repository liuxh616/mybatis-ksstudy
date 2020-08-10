package com.fengfang.test;

import com.fengfang.dao.IBlogDao;
import com.fengfang.domain.Blog;
import com.fengfang.utils.IDutils;
import com.fengfang.utils.MybatisUtil;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/7 15:48
 **/
public class TestCache {
  @Test
    public void testGetId(){
      System.out.println(IDutils.getId());
  }


  @Test
  public void  testFindById(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    Blog blog = blogDao.findById("1");
    System.out.println(blog);
    System.out.println("----------------------");
    Blog blog2 = blogDao.findById("1");
    System.out.println(blog2);
    session.close();
  }

  @Test
  public void  testFindCache(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    Blog blog = blogDao.findById("1");
    System.out.println(blog);
    System.out.println("--------查询结束--------------");
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("title", "测试缓存");
    map.put("id", "2");
    int result = blogDao.updateBlog(map);
    System.out.println("--------更新结束--------------");
    Blog blog2 = blogDao.findById("1");
    System.out.println(blog2);
    session.close();
  }

}
