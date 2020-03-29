package com.service;

import com.dao.UserDao;
import com.dommn.User;
import net.sf.ehcache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author lxc
 * @Date 2020/3/25 16:33
 * @Version V1.0
 **/
@Service
public class UserService {
    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY = "'user'";
    private static final String DEMO_CACHE_NAME = "users";

    @Autowired
    private UserDao userDao;

    //删除用户数据
    @CacheEvict(value = DEMO_CACHE_NAME,key = "'user_'+#uuid")//这是清除缓存
    public void delete(String uuid){
        userDao.delete(uuid);
    }

    //更新用户数据
    @CachePut(value = DEMO_CACHE_NAME,key = "'user_'+#user.getUuid()")
    public User update(User user) throws CacheException {
        User user1 = userDao.findByUuid(user.getUuid());
        if (null == user1){
            throw new  CacheException("Not Find");
        }
        user1.setAge(user.getAge());
        user1.setUserName(user.getUserName());
        return user1;
    }

    //查找用户数据
    @Cacheable(value=DEMO_CACHE_NAME,key="'user_'+#uuid")
    public User findByUuid(String uuid){
        //若找不到缓存将打印出提示语句
        System.err.println("没有走缓存！"+uuid);
        return userDao.findByUuid(uuid);
    }

    //保存用户数据
    @CacheEvict(value=DEMO_CACHE_NAME,key=CACHE_KEY)
    public int save(User user){
        return userDao.save(user);
    }
}
