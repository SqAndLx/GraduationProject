package com.graduation.service;

import com.graduation.mode.Recharge;

import java.util.List;

public interface RechargeService {
    /**
     * 充值
     * @return
     */
    void recharge(Recharge recharge);

    /**
     * 通过电话号查充值记录
     * @param tel
     * @return
     */
    List<Recharge> getRechargeByTel(String tel);
}
