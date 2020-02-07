package com.graduation.mode;

import lombok.Data;

@Data
public class User {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话
     */
    private String tel;
    /**
     * 介绍，职称
     */
    private String remarks;
    /**
     * 薪资
     */
    private Float salary;
}
