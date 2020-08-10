package com.fengfang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/7 15:43
 **/
public class MybatisUtil {
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
        return factory.openSession(true);
    }
}
