package com.graduation.controller;

import com.graduation.mode.User;
import com.graduation.service.UserService;
import com.graduation.utils.CodeMsg;
import com.graduation.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = {"api"}, produces = "application/json;charset=UTF-8")
@Api(tags = {"人员管理"})
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path = "/demo")
    public User index(@RequestParam(name = "id") String id ) {
        return userService.selectUserById(id);
    }

    /**
     * 新增员工账号
     */
    @PostMapping(path = "/insertYg")
    @ApiOperation(value = "新增员工账号", notes = "新增员工账号")
    public ResultData insertYg(@RequestBody User user){
        int code;
        try {
           code =userService.insertYg(user);
        } catch (Exception e) {
            code = 0;
            logger.error("新增员工出错", e);
        }
        return code != 0 ? ResultData.success(code) : ResultData.error(CodeMsg.SERVER_ERROR);

    }
    /**
     * 删除员工账号
     */
    @PostMapping(path = "/deleteYg")
    @ApiOperation(value = "删除员工账号", notes = "删除员工账号")
    public ResultData deleteYg(@RequestParam(name = "id") String id ){
        int code;
        try {
            code =userService.deleteYg(id);
        } catch (Exception e) {
            code = 0;
            logger.error("删除员工出错", e);
        }
        return code != 0 ? ResultData.success(code) : ResultData.error(CodeMsg.SERVER_ERROR);

    }

    /**
     * 更新员工账号
     */
    @PostMapping(path = "/updateYg")
    @ApiOperation(value = "更新员工账号", notes = "更新员工账号")
    public ResultData updateYg(@RequestBody User user){
        int code;
        try {
            code =userService.updateYg(user);
        } catch (Exception e) {
            code = 0;
            logger.error("更新员工出错", e);
        }
        return code != 0 ? ResultData.success(code) : ResultData.error(CodeMsg.SERVER_ERROR);

    }
    /**
     * 查询员工信息
     * @return
     * @Author ShiQing
     */
    @ApiOperation(value = "查询员工信息", notes = "查询员工信息")
    @PostMapping(value = "/getYgxx")
    public ResultData getYgxx() {
        List<User> list;
        try {
            list = userService.getYgxx();
        } catch (Exception e) {
            list = null;
            logger.error("查询员工信息出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);

    }
}
