package com.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.graduation.mode.Goods;
import com.graduation.service.GoodsService;
import com.graduation.utils.CodeMsg;
import com.graduation.utils.FtpUtil;
import com.graduation.utils.ResultData;
import com.graduation.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.net.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping(value = {"api"}, produces = "application/json;charset=UTF-8")
@Api(tags = {"商品表管理"})
public class GoodsController {
    // base64加密的前缀
    private static final String IMG_PRIFIX = "data:image/png;base64,";

    // ftp的IP地址
    @Value("${spring.ftp.ip}")
    private String ip;
    // ftp的端口号
    @Value("${spring.ftp.port}")
    private int port;
    // 账号
    @Value("${spring.ftp.username}")
    private String username;
    // 密码
    @Value("${spring.ftp.password}")
    private String password;

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
    @GetMapping(path = "/deleteSp/{id}")
    @ApiOperation(value = "删除商品", notes = "删除商品")
    public ResultData deleteSp(@PathVariable(name = "id") String id ){
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
    @GetMapping(value = "/getSpxxByName/{valu}")
    public ResultData getSpxxByLike(@PathVariable(name = "valu") String valu) {
        List<Goods> list;
        try {
            list = goodsService.getSpxxByLike(valu);
        } catch (Exception e) {
            list = null;
            logger.error("模糊查询商品信息出错", e);
        }
        return list != null ? ResultData.success(list) : ResultData.error(CodeMsg.SERVER_ERROR);

    }
    @ApiOperation(value = "保存上传的图片", notes = "保存上传的图片")
    @PostMapping(value = "/savePicture")
    public void savePicture(@RequestBody JSONObject params) {
        // base64解密
        Base64 base64 = new Base64();
        String imgstr = params.getString("imgUrl").replace(IMG_PRIFIX,"");
        byte[] picByte = base64.decode(imgstr);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(picByte);
        boolean result = new FtpUtil().uploadFile(UserUtil.getUUID()+".png",ip,port,username,password ,inputStream);
        if(result) {
            ResultData.success(CodeMsg.SUCCESS);
        }else {
            ResultData.error(CodeMsg.SERVER_ERROR);
        }
    }
}
