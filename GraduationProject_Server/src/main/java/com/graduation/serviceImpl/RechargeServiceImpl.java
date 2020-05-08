package com.graduation.serviceImpl;

import com.graduation.dao.RechargeMapper;
import com.graduation.mode.Recharge;
import com.graduation.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeMapper rechargeMapper;

    @Override
    public void recharge(Recharge recharge) {
        //修改VIP表中账户余额
        rechargeMapper.updateBalance(recharge);
        //生成充值记录
        rechargeMapper.addJl(recharge);
    }

    @Override
    public List<Recharge> getRechargeByTel(String tel) {
        List<Recharge> rechargeList = rechargeMapper.getRechargeByTel(tel);
        return rechargeList;
    }
}
