package com.graduation.controller;

import com.graduation.mode.Vip;
import com.graduation.service.VipService;
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
@Api(tags = {"会员管理"})
public class VipController {

    @Autowired
    private VipService vipService;

    private static final Logger logger = LoggerFactory.getLogger(VipController.class);

    /**
     * 新增会员账号
     */
    @PostMapping(path = "/insertHy")
    @ApiOperation(value = "新增会员账号", notes = "新增会员账号")
    public ResultData insertHy(@RequestBody Vip vip){
        int code;
        try {
            code =vipService.insertHy(vip);
        } catch (Exception e) {
            code = 0;
            logger.error("新增会员出错", e);
        }
        return code != 0 ? ResultData.success(code) : ResultData.error(CodeMsg.SERVER_ERROR);

    }
    /**
     * 删除会员账号
     */
    @PostMapping(path = "/deleteHy")
    @ApiOperation(value = "删除会员账号", notes = "删除会员账号")
    public ResultData deleteHy(@RequestParam(name = "id") String id ){
        int code;
        try {
            code =vipService.deleteHy(id);
        } catch (Exception e) {
            code = 0;
            logger.error("删除会员出错", e);
        }
        return code != 0 ? ResultData.success(code) : ResultData.error(CodeMsg.SERVER_ERROR);

    }

    /**
     * 更新会员账号
     */
    @PostMapping(path = "/updateHy")
    @ApiOperation(value = "更新会员账号", notes = "更新会员账号")
    public ResultData updateHy(@RequestBody Vip vip){
        int code;
        try {
            code =vipService.updateHy(vip);
        } catch (Exception e) {
            code = 0;
            logger.error("更新会员出错", e);
        }
        return code != 0 ? ResultData.success(code) : ResultData.error(CodeMsg.SERVER_ERROR);

    }
    /**
     * 查询会员信息
     * @return
     * @Author ShiQing
     */
    @ApiOperation(value = "查询会员信息", notes = "查询会员信息")
    @PostMapping(value = "/getHyxx")
    public ResultData getHyxx() {
        List<Vip> list;
        try {
            list = vipService.getHyxx();
        } catch (Exception e) {
            list = null;
            logger.error("查询会员信息出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);

    }
}
