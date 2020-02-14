package com.graduation.mode;

import lombok.Data;

import java.util.Date;


@Data
public class Vip {

    /**
     *会员id
     */
    private String id;
    /**
     *会员姓名
     */
    private String name;
    /**
     *性别
     */
    private String sex;
    /**
     *电话号码
     */
    private String tel;
    /**
     *会员积分
     */
    private Integer integral;
    /**
     *会员等级
     */
    private String grade;
    /**
     *会员办理日期
     */
    private Date data;
    /**
     *办理人
     */
    private String updateName;
    /**
     *账户余额
     */
    private Float balance;
}
