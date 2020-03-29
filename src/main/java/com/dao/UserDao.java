package com.dao;

import com.dommn.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDao
 * @Description: TODO
 * @Author lxc
 * @Date 2020/3/25 16:31
 * @Version V1.0
 **/
@Mapper
@Component
public interface UserDao {
    void delete(String uuid);

    User update(@Param("user") User user);

    User findByUuid(String uuid);

    int save(@Param("user") User user);
}
