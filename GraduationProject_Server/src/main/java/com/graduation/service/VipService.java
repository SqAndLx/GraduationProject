package com.graduation.service;

import com.graduation.mode.Vip;

import java.util.List;

public interface VipService {
    /**
     * 新增会员
     */
    int insertHy(Vip vip);

    /**
     * 删除会员
     */
    int deleteHy(String id);
    /**
     * 更新会员
     */
    int updateHy(Vip vip);

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
    List<Vip> selectHyByTel(String tel);
}
