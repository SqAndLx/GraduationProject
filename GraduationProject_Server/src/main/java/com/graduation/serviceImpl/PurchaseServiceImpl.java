package com.graduation.serviceImpl;

import com.graduation.dao.PurchaseMapper;
import com.graduation.mode.Purchase;
import com.graduation.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getXfxx() {
        List<Purchase> list =purchaseMapper.getXfxx();
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


}
