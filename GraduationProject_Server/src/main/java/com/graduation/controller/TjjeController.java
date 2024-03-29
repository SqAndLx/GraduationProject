package com.graduation.controller;

import com.graduation.mode.Tjje;
import com.graduation.service.TjjeService;
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

import java.util.List;

@RestController
@RequestMapping(value = {"api"}, produces = "application/json;charset=UTF-8")
@Api(tags = {"统计金额"})
public class TjjeController {

    @Autowired
    private TjjeService tjjeService;

    private static final Logger logger = LoggerFactory.getLogger(TjjeController.class);

    /**
     * 统计金额饼状图
     * @return
     * @Author ShiQing
     */
    @ApiOperation(value = "统计金额饼状图", notes = "统计金额饼状图")
    @PostMapping(value = "/bzt")
    public ResultData getBzt() {
        List<Tjje> list;
        try {
            list = tjjeService.getBzt();

        } catch (Exception e) {
            list = null;
            logger.error("获取饼状图的数据出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);

    }

    /**
     * 当前年份盈利和总计
     * @return
     */
    @ApiOperation(value = "当前年份盈利和总计", notes = "当前年份盈利和总计")
    @PostMapping(value = "/getYlZj")
    public ResultData getYlZj(){
        List<Tjje> list;
        try {
            list = tjjeService.getYlZj();

        } catch (Exception e) {
            list = null;
            logger.error("获取当前年份盈利和总计出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);
    }
    /**
     * 统计前五个月各个月盈利合计，收入合计
     * @return
     */
    @ApiOperation(value = "统计前五个月各个月盈利合计，收入合计", notes = "统计前五个月各个月盈利合计，收入合计")
    @PostMapping(value = "/getYYlZj")
    public ResultData getYYlZj(){
        List<Tjje> list;
        try {
            list = tjjeService.getYYlZj();

        } catch (Exception e) {
            list = null;
            logger.error("统计前五个月各个月盈利合计，收入合计出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);
    }
}




