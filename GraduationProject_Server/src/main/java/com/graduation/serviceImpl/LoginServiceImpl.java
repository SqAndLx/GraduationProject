package com.graduation.serviceImpl;

import com.graduation.dao.LoginMapper;
import com.graduation.mode.Loginer;
import com.graduation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 根据账号和密码查询登录人
     * @param number
     * @param password
     * @return
     */
    @Override
    public Loginer getLoginerByNumberAndPassWord(String number, String password) {
        return loginMapper.getLoginerByNumberAndPassWord(number, password);
    }

    @Override
    public void updateMm(String number, String password) {
        loginMapper.updateMm(number,password);
    }

    @Override
    public void zc(String number, String password) {
        loginMapper.zc(number,password);
    }
}
