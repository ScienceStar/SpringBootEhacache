package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @ClassName StarteApplication
 * @Description: TODO 启动类
 * @Author lxc
 * @Date 2020/3/25 16:07
 * @Version V1.0
 **/
@SpringBootApplication
@MapperScan("com.dao")
@EnableCaching
public class StarteApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarteApplication.class,args);
    }
}
