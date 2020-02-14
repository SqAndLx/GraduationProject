package com.graduation.service;

import com.graduation.mode.User;

import java.util.List;

public interface  UserService {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectUserById(String id);

    /**
     * 新增员工
     */
    void insertYg(User user);

    /**
     * 删除员工
     */
    void deleteYg(String id);
    /**
     * 更新员工
     */
    void updateYg(User user);

    /**
     * 查询员工信息
     * @return
     */
    List<User> getYgxx();
}
