package com.graduation.serviceImpl;

import com.graduation.dao.PurchaseMapper;
import com.graduation.mode.Purchase;
import com.graduation.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getXfxx() {
        List<Purchase> list =purchaseMapper.getXfxx();
        // 这块字段设计是不对的，业务表乱加字段剥离不开，只能强行实现
        // 把这个id的元素删掉
        list.removeIf(item -> item.getId().equals("0000"));
        // 按照时间排序
        list.sort(Comparator.comparing(Purchase::getData));
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
        //修改库存
    }
}
