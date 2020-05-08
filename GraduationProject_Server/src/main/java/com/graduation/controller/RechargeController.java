package com.graduation.controller;

import com.graduation.mode.Goods;
import com.graduation.mode.Recharge;
import com.graduation.service.RechargeService;
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
@Api(tags = {"充值记录表管理"})
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    private static final Logger logger = LoggerFactory.getLogger(RechargeController.class);

    /**
     * 充值
     * @return
     */
    @ApiOperation(value = "充值", notes = "充值")
    @PostMapping(value = "/recharge")
    public ResultData recharge(@RequestBody Recharge recharge){
        try {
            rechargeService.recharge(recharge);
        } catch (Exception e) {
            logger.error("充值出错", e);
            return  ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(CodeMsg.SUCCESS);
    }

    /**
     * 通过电话号展示充值记录
     * @return
     */
    @ApiOperation(value = "通过电话号展示充值记录", notes = "通过电话号展示充值记录")
    @GetMapping(value = "/getRechargeByTel/{tel}")
    public ResultData getRechargeByTel(@PathVariable(name = "tel") String tel){
        List<Recharge> list;
        try {
            list =rechargeService.getRechargeByTel(tel);
        } catch (Exception e) {
            list = null;
            logger.error("通过电话号展示充值记录出错", e);
            return  ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(list);
    }
}
