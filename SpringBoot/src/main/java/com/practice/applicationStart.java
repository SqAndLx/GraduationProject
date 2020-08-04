package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// mapper文件的扫包路径
@MapperScan("com.practice.mapper")
public class applicationStart {
    public static void main(String[] args) {
        SpringApplication.run(applicationStart.class);
    }
}
