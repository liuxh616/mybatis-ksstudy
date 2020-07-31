package com.fengfang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/7/30 12:27
 **/
public class MybatisUtils {
    private static SqlSessionFactory factory;
    static {
        try{
            //使用mybatis第一步获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream stream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(stream);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取 一个SqlSession对象
     * @return
     */
    public static SqlSession getSqlSession(){
        return factory.openSession();
    }
}
