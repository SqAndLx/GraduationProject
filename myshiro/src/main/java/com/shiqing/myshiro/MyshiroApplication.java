package com.shiqing.myshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.shiqing.myshiro.dao")
public class MyshiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshiroApplication.class, args);
    }

}
