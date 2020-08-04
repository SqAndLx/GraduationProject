package com.practice.controller;

import com.practice.bean.Entity.ExampleEntity;
import com.practice.service.BeanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/TestController")
@Api("测试API")
public class TestController {

    @Autowired
    private BeanService beanService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value="测试")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功") })
    public List<ExampleEntity> test() {
        List<ExampleEntity> allBeanList = beanService.getAllBean();
        return allBeanList;
    }
}
