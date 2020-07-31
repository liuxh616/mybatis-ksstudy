package com.fengfang.domain;

import java.io.Serializable;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/7/29 16:55
 **/
public class User implements Serializable {
    private Integer id;
    private String name;
    private String pwd;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
