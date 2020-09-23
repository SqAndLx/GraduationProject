package com.shiqing.myshiro.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler{

    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return "没有通过权限验证！";
    }

    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthenticationException e) {
        log.error("账号或密码错误！", e);
        return "账号或密码错误！";
    }
}
