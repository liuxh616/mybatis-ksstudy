package com.fengfang.utils;

import java.util.UUID;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/7 15:53
 **/
@SuppressWarnings("all")  //抑制警告
public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
