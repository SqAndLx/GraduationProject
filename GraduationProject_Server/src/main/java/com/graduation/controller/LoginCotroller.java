package com.graduation.controller;

import com.graduation.mode.Loginer;
import com.graduation.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"api"}, produces = "application/json;charset=UTF-8")
@Api(tags = {"登录"})
public class LoginCotroller {

    @Autowired
    private LoginService loginService;
    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping(path = "/Login")
    public Loginer Login(@RequestParam(name = "number") String number , @RequestParam(name = "password") String password ) {
        // 根据账号密码查询登录人
        Loginer loginer = loginService.getLoginerByNumberAndPassWord(number, password);
        return loginer == null ? null : loginer;
    }
}
