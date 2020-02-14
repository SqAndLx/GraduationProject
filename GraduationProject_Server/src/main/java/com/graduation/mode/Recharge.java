package com.graduation.mode;

import lombok.Data;

import java.util.Date;
@Data
public class Recharge {

    /***
     * 会员id
     */
    private String id;
    /**
     * 会员号
     */
    private String tel;
    /**
     * 充值金额
     */
    private Integer rechargemoney;
    /**
     * 充值方式
     */
    private Integer rechargeway;
    /**
     * 充值时间
     */
    private Date data;
    /**
     * 备注
     */
    private String remarks;
}
