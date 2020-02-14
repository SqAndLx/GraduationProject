package com.graduation.controller;

import com.graduation.mode.Goods;
import com.graduation.service.GoodsService;
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
@Api(tags = {"商品表管理"})
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    /**
     * 新增商品
     */
    @PostMapping(path = "/insertSp")
    @ApiOperation(value = "新增商品", notes = "新增商品")
    public ResultData insertSp(@RequestBody Goods goods){
        try {
            goodsService.insertSp(goods);
        } catch (Exception e) {
            logger.error("新增商品出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(CodeMsg.SUCCESS);

    }
    /**
     * 通过id删除某商品
     */
    @PostMapping(path = "/deleteSp")
    @ApiOperation(value = "删除商品", notes = "删除商品")
    public ResultData deleteSp(@RequestParam(name = "id") String id ){
        try {
            goodsService.deleteSp(id);
        } catch (Exception e) {
            logger.error("通过id删除某商品出错", e);
            return  ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(CodeMsg.SUCCESS);
    }

    /**
     * 更新商品
     */
    @PostMapping(path = "/updateSp")
    @ApiOperation(value = "更新商品", notes = "更新商品")
    public ResultData updateSp(@RequestBody Goods goods){
        try {
            goodsService.updateSp(goods);
        } catch (Exception e) {
            logger.error("更新商品出错", e);
            return  ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(CodeMsg.SUCCESS);

    }
    /**
     * 查询商品信息
     * @return
     * @Author ShiQing
     */
    @ApiOperation(value = "查询商品信息", notes = "查询商品信息")
    @PostMapping(value = "/getSpxx")
    public ResultData getSpxx() {
        List<Goods> list;
        try {
            list = goodsService.getSpxx();
        } catch (Exception e) {
            list = null;
            logger.error("查询商品信息出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);

    }

    /**
     * 通过商品id修改库存
     */
    @PostMapping(path = "/updateKcById")
    @ApiOperation(value = "通过商品id修改库存", notes = "通过商品id修改库存")
    public ResultData updateKcById(@RequestParam(name = "id") String id,@RequestParam(name = "number") Integer number){
        try {
            goodsService.updateKcById(id,number);
        } catch (Exception e) {
            logger.error("通过商品id修改库存出错", e);
            return  ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(CodeMsg.SUCCESS);

    }
    /**
     * 查询商品信息(模糊查询)
     * @return
     * @Author ShiQing
     */
    @ApiOperation(value = "查询商品信息(模糊查询)", notes = "查询商品信息(模糊查询)")
    @PostMapping(value = "/getSpxxByLike")
    public ResultData getSpxxByLike(@RequestParam("name") String name) {
        List<Goods> list;
        try {
            list = goodsService.getSpxxByLike(name);
        } catch (Exception e) {
            list = null;
            logger.error("模糊查询商品信息出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);

    }

}
