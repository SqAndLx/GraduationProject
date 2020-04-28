package com.graduation.service;

import com.graduation.mode.Purchase;

import java.util.List;

public interface PurchaseService {

    /**
     * 查询消费信息
     * @return
     */
    List<Purchase> getXfxx();

    /**
     * 获取折扣
     * @return
     */
    Purchase getZk();

    /**
     * 修改折扣
     * @param type
     */
    void updateZk(String type);
}
