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
        try {
            vipService.insertHy(vip);
        } catch (Exception e) {
            logger.error("新增会员出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(CodeMsg.SUCCESS);

    }
    /**
     * 删除会员账号
     */
    @PostMapping(path = "/deleteHy")
    @ApiOperation(value = "删除会员账号", notes = "删除会员账号")
    public ResultData deleteHy(@RequestParam(name = "id") String id ){
        try {
            vipService.deleteHy(id);
        } catch (Exception e) {
            logger.error("删除会员出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(CodeMsg.SUCCESS);
    }

    /**
     * 更新会员账号
     */
    @PostMapping(path = "/updateHy")
    @ApiOperation(value = "更新会员账号", notes = "更新会员账号")
    public ResultData updateHy(@RequestBody Vip vip){
        try {
            vipService.updateHy(vip);
        } catch (Exception e) {
            logger.error("更新会员出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(CodeMsg.SUCCESS);
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
            logger.error("查询会员信息出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(list);

    }

    /**
     * 通过手机号查询会员
     * @return
     */
    @ApiOperation(value = "通过手机号查询会员", notes = "通过手机号查询会员")
    @PostMapping(value = "/selectHyByTel")
    public ResultData selectHyByTel(@RequestParam(name = "tel") String tel ){
        Vip vip;
        try {
             vip = vipService.selectHyByTel(tel);
        } catch (Exception e) {
            logger.error("通过手机号查询会员出错！", e);
            return  ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(vip);
    }

    @ApiOperation(value = "动态传入字段进行模糊查询", notes = "动态传入字段进行模糊查询")
    @GetMapping(value = "/selectHyByZd/{zd}/{valu}")
    public ResultData selectHyByZd(@PathVariable(name = "zd") String zd,@PathVariable(name = "valu") String valu ){
        List<Vip> list;
        try {
            list = vipService.selectHyByZd(zd,valu);
        } catch (Exception e) {
            logger.error("动态传入字段进行模糊查询出错", e);
            return ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return ResultData.success(list);
    }
}
