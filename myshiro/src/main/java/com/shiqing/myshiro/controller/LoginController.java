package com.shiqing.myshiro.controller;

import com.shiqing.myshiro.bean.User;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping("/login")
    public String login(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getCname(),
                user.getCpassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            logger.error("用户名不存在！", e);
            return "用户名不存在！";
        }catch (IncorrectCredentialsException e) {
            logger.error("用户名或密码错误！", e);
            return "用户名或密码错误！";
        }
        return "login success";
    }

    //注解验角色和权限
//    @RequiresRoles("admin")
//    @RequiresPermissions("add")
//    @RequestMapping("/index")
//    public String index() {
//        return "index!";
//    }


    @RequestMapping("/testAaddress")
    public String testAddress() {
        return "我已经登陆了！";
    }

    @RequestMapping("/error2")
    public String error() {
        return "失败了！";
    }
}
