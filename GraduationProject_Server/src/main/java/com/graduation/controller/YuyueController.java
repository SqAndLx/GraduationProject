package com.graduation.controller;

import com.graduation.mode.Yuyue;
import com.graduation.service.GoodsService;
import com.graduation.service.YuyueService;
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
@Api(tags = {"预约"})
public class YuyueController {

    @Autowired
    private YuyueService yuYueService;

    private static final Logger logger = LoggerFactory.getLogger(YuyueController.class);
    /**
     * 新增商品
     */
    @PostMapping(path = "/insertYy")
    @ApiOperation(value = "新增预约", notes = "新增预约")
    public ResultData insertSp(@RequestBody Yuyue yy){
        try {
            yuYueService.insertYy(yy);
        } catch (Exception e) {
            logger.error("新增预约出错！", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(CodeMsg.SUCCESS);

    }


    /**
     * 查询订单
     */
    @PostMapping(path = "/getYy")
    @ApiOperation(value = "新增预约", notes = "新增预约")
    public ResultData getYy(@RequestParam(name = "name")  String name){
        List<Yuyue> yy;
        try {
            yy = yuYueService.getYy(name);
        } catch (Exception e) {
            logger.error("新增预约出错！", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(yy);

    }

    /**
     * 查询订单
     */
    @PostMapping(path = "/deleteYy")
    @ApiOperation(value = "新增预约", notes = "新增预约")
    public ResultData deleteYy(@RequestParam(name = "id")  String name){
        try {
           yuYueService.deleteYy(name);
        } catch (Exception e) {
            logger.error("新增预约出错！", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(CodeMsg.SUCCESS);

    }

    /**
     * 查询订单
     */
    @PostMapping(path = "/getAll")
    @ApiOperation(value = "新增预约", notes = "新增预约")
    public ResultData getAll(){
        List<Yuyue> yy;
        try {
            yy = yuYueService.getAll();
        } catch (Exception e) {
            logger.error("新增预约出错！", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(yy);

    }
}
