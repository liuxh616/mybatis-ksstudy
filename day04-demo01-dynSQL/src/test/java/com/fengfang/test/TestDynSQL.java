package com.fengfang.test;

import com.fengfang.dao.IBlogDao;
import com.fengfang.domain.Blog;
import com.fengfang.utils.IDutils;
import com.fengfang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

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
//    map.put("views",8000);
    List<Blog> blogList = blogDao.findAllIf(map);
    for (Blog blog : blogList) {
      System.out.println(blog);
    }
    session.close();
  }

  @Test
  public void  testFindAllRefId(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    Map map = new HashMap();
    map.put("title","微服务 多简单呀！");
//    map.put("views",8000);
    List<Blog> blogList = blogDao.findAllRefId(map);
    for (Blog blog : blogList) {
      System.out.println(blog);
    }
    session.close();
  }
 @Test
  public void testFindAllLike(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    Map map = new HashMap();
    map.put("views",2000);   //others条件
    map.put("title","微服务");  //when条件优先了
    List<Blog> blogList = blogDao.findAllLike(map);
    for (Blog blog : blogList) {
      System.out.println(blog);
    }
    session.close();
  }

  @Test
  public void testUpdateBlog(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    Map map = new HashMap();
    map.put("id","64c98c65738747718746410aafe12101");   //others条件
    map.put("title","测试标题哦2");
    map.put("author", "测试作者");
    int resutl = blogDao.updateBlog(map);

    session.commit();
    session.close();
  }

  @Test
  public void testFindAllForeach(){
    SqlSession session = MybatisUtil.getSqlSession();
    IBlogDao blogDao = session.getMapper(IBlogDao.class);
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(1);
//    arrayList.add(2);
    arrayList.add(3);
    Map map = new HashMap();
    map.put("ids",arrayList);   //others条件
    List<Blog> blogList = blogDao.findAllForeach(map);
    for (Blog blog : blogList) {
      System.out.println(blog);
    }
    session.close();
  }
}
