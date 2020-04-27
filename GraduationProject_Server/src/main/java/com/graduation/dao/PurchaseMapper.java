package com.graduation.dao;

import com.graduation.mode.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PurchaseMapper {

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
    /**
     * 添加消费记录
     * @param purchase
     */
    void addXfjl(Purchase purchase);
}
