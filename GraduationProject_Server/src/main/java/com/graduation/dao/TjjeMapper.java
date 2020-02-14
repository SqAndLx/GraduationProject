package com.graduation.dao;

import com.graduation.mode.Tjje;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * @param year
     * @return
     */
    Integer getTotal(@Param("year") String year, @Param("tomYear")String tomYear);

    /**
     * 购买商品的盈利金额之和
     * @param year
     * @return
     */
    Integer ylYsp(@Param("year")String year,@Param("tomYear")String tomYear);

    /**
     * 无购买商品的盈利金额之和
     * @param year
     * @return
     */
    Integer ylWsp(@Param("year")String year,@Param("tomYear")String tomYear);
}
