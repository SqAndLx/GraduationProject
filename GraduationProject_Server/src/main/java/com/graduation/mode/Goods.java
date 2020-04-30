package com.graduation.mode;

import lombok.Data;

@Data
public class Goods {
    /**
     *商品id
     */
    private String id;
    /**
     *商品名
     */
    private String name;
    /**
     * 类别
     */
    private String type;
    /**
     * 单价
     */
    private Float price;
    /**
     * 库存
     */
    private Integer number;
    /**
     * 进价
     */
    private Float cost;
    /**
     * 简介
     */
    private String remarks;
}
