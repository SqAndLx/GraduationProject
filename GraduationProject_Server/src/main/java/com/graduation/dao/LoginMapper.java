package com.graduation.dao;

import com.graduation.mode.Loginer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

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
