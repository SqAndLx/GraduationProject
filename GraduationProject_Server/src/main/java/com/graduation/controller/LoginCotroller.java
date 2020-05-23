package com.graduation.controller;

import com.graduation.mode.Loginer;
import com.graduation.service.LoginService;
import com.graduation.utils.CodeMsg;
import com.graduation.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"api"}, produces = "application/json;charset=UTF-8")
@Api(tags = {"登录"})
public class LoginCotroller {

    @Autowired
    private LoginService loginService;

    private static final Logger logger = LoggerFactory.getLogger(LoginCotroller.class);
    @ApiOperation(value = "登录", notes = "登录")
    @GetMapping(path = "/Login/{number}/{password}")
    public Loginer Login(@PathVariable(name = "number") String number , @PathVariable(name = "password") String password ) {
        // 根据账号密码查询登录人
        Loginer loginer = loginService.getLoginerByNumberAndPassWord(number, password);
        return loginer == null ? null : loginer;
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PostMapping(path = "/update")
    public ResultData update(@RequestParam(name = "number") String number , @RequestParam(name = "password") String password ) {
        try {
            loginService.updateMm(number,password);
        } catch (Exception e) {
            logger.error("修改密码出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(CodeMsg.SUCCESS);
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PostMapping(path = "/zc")
    public ResultData zc(@RequestParam(name = "zh") String number , @RequestParam(name = "password") String password ) {
        try {
            loginService.zc(number,password);
        } catch (Exception e) {
            logger.error("修改密码出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(CodeMsg.SUCCESS);
    }
}
