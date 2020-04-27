package com.graduation.controller;

import com.graduation.mode.Purchase;
import com.graduation.service.PurchaseService;
import com.graduation.utils.CodeMsg;
import com.graduation.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping(value = {"api"}, produces = "application/json;charset=UTF-8")
@Api(tags = {"消费记录"})
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    /**
     * 查询消费记录
     * @return
     * @Author ShiQing
     */
    @ApiOperation(value = "查询消费记录", notes = "查询消费记录")
    @PostMapping(value = "/getXfxx")
    public ResultData getXfxx() {
        List<Purchase> list;
        try {
            list = purchaseService.getXfxx();
        } catch (Exception e) {
            list = null;
            logger.error("查询消费记录出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);

    }

    /**
     * 获取折扣
     * @return
     * @Author ShiQing
     */
    @ApiOperation(value = "获取折扣", notes = "获取折扣")
    @PostMapping(value = "/getZk")
    public ResultData getZk() {
        Purchase purchase;
        try {
            purchase = purchaseService.getZk();
        } catch (Exception e) {
            logger.error("获取折扣出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(purchase);
    }

    /**
     * 修改折扣
     * @param type
     * @return
     */
    @ApiOperation(value = "修改折扣", notes = "修改折扣")
    @GetMapping(path = "/updateZk")
    public ResultData updateZk(@RequestParam(value = "type") String type ) {
        try {
            purchaseService.updateZk(type);
        } catch (Exception e) {
            logger.error("修改折扣出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(CodeMsg.SUCCESS);
    }
}
