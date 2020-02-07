package com.graduation.dao;

import com.graduation.mode.Tjje;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TjjeMapper {


    /**
     * 获取饼状图数据
     * @return
     */
    List<Tjje> getBzt();

    /**
     * 获取当年总计
     * @param month
     * @return
     */
    Integer getTotal(String month,String tomYear);

    /**
     * 购买商品的盈利金额之和
     * @param month
     * @return
     */
    Integer ylYsp(String month,String tomYear);

    /**
     * 无购买商品的盈利金额之和
     * @param month
     * @return
     */
    Integer ylWsp(String month,String tomYear);
}
