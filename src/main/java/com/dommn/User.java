package com.dommn;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description: TODO
 * @Author lxc
 * @Date 2020/3/25 16:13
 * @Version V1.0
 **/
public class User implements Serializable {
    private long id;
    private String uuid;
    private String userName;
    private Integer age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
