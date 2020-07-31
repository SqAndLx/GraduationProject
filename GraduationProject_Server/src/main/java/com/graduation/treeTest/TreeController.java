package com.graduation.treeTest;

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

/**
 * 树形结构测试类
 */
@RestController
@RequestMapping(value = {"api"}, produces = "application/json;charset=UTF-8")
@Api(tags = {"树形结构测试类"})
public class TreeController {

    private static final Logger logger = LoggerFactory.getLogger(TreeController.class);

    @Autowired
    private TreeTestService treeTestService;
    /**
     * 查询树结构数据
     */
    @PostMapping(path = "/selectTreeData")
    @ApiOperation(value = "查询树结构数据", notes = "查询树结构数据")
    public ResultData selectTreeData(){
        List<TreeModel> list;
        try {
            list = treeTestService.getTreeData();
        } catch (Exception e) {
            logger.error("查询树结构数据失败", e);
            return  ResultData.error(CodeMsg.SERVER_ERROR);
        }
        return  ResultData.success(list);

    }

}
