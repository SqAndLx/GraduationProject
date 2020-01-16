package com.graduation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.graduation.mode.User;

@Mapper
public interface  UserMapper {
    User selectUser(@Param("id") String id);
}
