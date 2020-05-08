package com.graduation.dao;

import com.graduation.mode.Recharge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RechargeMapper {
    /**
     * 修改VIP表中账户余额
     * @return
     */
     void updateBalance(Recharge recharge);

    /**
     * 生成充值记录
     * @param recharge
     * @return
     */
    void addJl(Recharge recharge);

    /**
     * 通过id查充值记录
     * @param tel
     * @return
     */
    List<Recharge> getRechargeByTel(String tel);
}
