package com.xywei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author future
 * @DateTime 2019/11/15 22:00
 * @Description
 */
@SpringBootApplication
@MapperScan("com.xywei.mapper")
public class ApplicationUAA {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationUAA.class,args);
    }
}
