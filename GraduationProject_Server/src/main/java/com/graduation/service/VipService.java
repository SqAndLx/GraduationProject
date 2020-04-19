package com.graduation.service;

import com.graduation.mode.Vip;

import java.util.List;

public interface VipService {
    /**
     * 新增会员
     */
    void insertHy(Vip vip);

    /**
     * 删除会员
     */
    void deleteHy(String id);
    /**
     * 更新会员
     */
    void updateHy(Vip vip);

    /**
     * 查询会员信息
     * @return
     */
    List<Vip> getHyxx();

    /**
     * 通过手机号查询会员信息
     * @param tel
     * @return
     */
    Vip selectHyByTel(String tel);

    /**
     * 动态传入字段进行模糊查询
     * @param zd
     * @param valu
     * @return
     */
    List<Vip> selectHyByZd(String zd,String valu);
}
