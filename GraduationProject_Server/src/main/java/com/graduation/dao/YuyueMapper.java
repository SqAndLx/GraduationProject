package com.graduation.dao;

import com.graduation.mode.Yuyue;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YuyueMapper {

    void insertYy(Yuyue yy);

    List<Yuyue> getYy(@Param("name") String name);

    @Delete("DELETE FROM PRACTISE.ORDER WHERE C_ID = #{name}")
    void deleteYy(@Param("name") String name);

    List<Yuyue> getAll();
}
