package com.graduation.serviceImpl;

import com.graduation.dao.GoodsMapper;
import com.graduation.dao.PurchaseMapper;
import com.graduation.dao.VipMapper;
import com.graduation.mode.Purchase;
import com.graduation.mode.Vip;
import com.graduation.service.PurchaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private VipMapper vipMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Purchase> getXfxx() {
        List<Purchase> list = purchaseMapper.getXfxx();
        // 这块字段设计是不对的，业务表乱加字段剥离不开，只能强行实现
        // 把这个id的元素删掉
        list.removeIf(item -> item.getId().equals("0000"));
        for (Purchase purchase : list
        ) {
            String goods = "";
            //如果是多个商品的情况下
            if (purchase.getGoodsId().contains(",")) {
                List<String> strArr = Arrays.asList(purchase.getGoodsId().split(","));
                List goodsArr = purchaseMapper.getGoodsName(strArr);
                for (int i = 0; i < goodsArr.size(); i++) {
                    goods += goodsArr.get(i) + " ";
                }
            } else {
                goods = purchaseMapper.getGoodName(purchase.getGoodsId());
            }
            purchase.setGoodsId(goods);
        }
        // 按照时间排序
        list.sort(Comparator.comparing(Purchase::getData).reversed());
        return list;
    }

    @Override
    public Purchase getZk() {
        return purchaseMapper.getZk();
    }

    @Override
    public void updateZk(String type) {
        purchaseMapper.updateZk(type);
    }

    @Override
    public void addXfjl(Purchase purchase) {
        //添加消费记录
        purchaseMapper.addXfjl(purchase);
        //修改账户余额.积分
        if (StringUtils.isNotBlank(purchase.getCustomerId())) {
            //获取当前会员信息
            Vip vipXx = vipMapper.selectHyByTel(purchase.getTel());
            vipXx.setBalance(vipXx.getBalance() - Float.parseFloat(purchase.getHymoney()));
            vipXx.setIntegral(vipXx.getIntegral() + Integer.valueOf(StringUtils.substringBefore(purchase.getHymoney(),".")));
            //修改
            vipMapper.updateHy(vipXx);
        }
        //修改库存
        List<String> strArr = Arrays.asList(purchase.getGoodsId().split(","));
        for (String goodId : strArr) {
            Integer kcCount = goodsMapper.getKcbyId(goodId);
            goodsMapper.updateKcById(goodId, kcCount - 1);
        }
    }
}
