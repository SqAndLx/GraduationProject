package com.graduation.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.graduation.user.mode.User;

@Mapper
public interface  UserMapper {
    /**
     * 根据id查寻用户信息
     * @param id
     * @return
     */
    User selectUserById(@Param("id") String id);
}
