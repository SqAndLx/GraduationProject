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
}
