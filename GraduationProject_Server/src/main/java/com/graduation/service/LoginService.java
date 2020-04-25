package com.graduation.service;

import com.graduation.mode.Loginer;
import org.springframework.web.bind.annotation.RequestParam;

public interface LoginService {

    /**
     * 根据账号和密码查询登录人
     * @param number
     * @param password
     * @return
     */
    Loginer getLoginerByNumberAndPassWord(String number, String password);

    /**
     * 修改密码
     * @param number
     * @param password
     */
    void updateMm(String number,String password);
}
