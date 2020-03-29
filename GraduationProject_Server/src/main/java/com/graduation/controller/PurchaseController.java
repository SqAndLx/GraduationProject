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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
