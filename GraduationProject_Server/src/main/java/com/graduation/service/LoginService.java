package com.graduation.service;

import com.graduation.mode.Loginer;

public interface LoginService {

    /**
     * 根据账号和密码查询登录人
     * @param number
     * @param password
     * @return
     */
    Loginer getLoginerByNumberAndPassWord(String number, String password);
}
