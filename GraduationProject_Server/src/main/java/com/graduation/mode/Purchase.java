package com.graduation.mode;
import lombok.Data;

import java.sql.Array;
import java.util.Date;
import java.util.List;

@Data
public class Purchase {
    /**
     * id
     */
    private String id;
    /**
     * 会员名称
     */
    private String name;
    /**
     * 消费日期
     */
    private Date data;
    /**
     * 会员手机号
     */
    private String tel;
    /**
     * 会员号
     */
    private String phone;
    /**
     * 消费内容
     */
    private String detail;
    /**
     * 会员价
     */
    private String hymoney;
    /**
     * 消费金额
     */
    private String money;
    /**
     * 理发师
     */
    private String barber;
    /**
     * 支付方式
     */
    private String way;
    /**
     * 配置项
     */
    private String type;

    private String customerId;
    private String personnelId;
    private List goodsId;
    private int codeId;

}
