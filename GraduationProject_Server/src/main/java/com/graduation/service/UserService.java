package com.graduation.service;

import com.graduation.mode.User;

public interface  UserService {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectUserById(String id);
}
