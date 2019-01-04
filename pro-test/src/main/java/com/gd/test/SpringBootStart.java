package com.gd.test;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @DATA 2019-01-03 17:57
 * @Author zhangguowei  WeChat:17630376104
 * @Description TODOtitle
 */
@SpringBootApplication
@MapperScan("com.gd.test.mapper")
public class SpringBootStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class, args);
    }
}
