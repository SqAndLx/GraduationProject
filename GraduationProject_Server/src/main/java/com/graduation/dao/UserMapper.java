package com.graduation.dao;

import org.apache.ibatis.annotations.*;
import com.graduation.mode.User;

import java.util.List;

@Mapper
public interface  UserMapper {
    /**
     * 根据id查寻用户信息
     * @param id
     * @return
     */
    User selectUserById(@Param("id") String id);

    int insertYg(User user);

    @Delete("DELETE FROM personnel WHERE c_id = #{id}")
    int deleteYg(@Param("id") String id);

    int updateYg(User user);

    /**
     * 查询员工信息
     * @return
     */
    List<User> getYgxx();
}
