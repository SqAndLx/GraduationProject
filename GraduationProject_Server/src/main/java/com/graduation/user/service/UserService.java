package com.graduation.user.service;

import com.graduation.user.mode.User;

public interface  UserService {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectUserById(String id);
}
