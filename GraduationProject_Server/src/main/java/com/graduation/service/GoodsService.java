package com.graduation.service;

import com.graduation.mode.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 新增商品
     */
    void insertSp(Goods goods);

    /**
     * 删除商品
     */
    void deleteSp(String id);
    /**
     * 更新商品
     */
    void updateSp(Goods goods);

    /**
     * 查询商品信息
     * @return
     */
    List<Goods> getSpxx();

    /**
     * 通过商品id修改库存
     * @param id
     * @return
     */
    void updateKcById(String id,Integer number);

    /**
     * 模糊查询商品信息
     * @param name
     * @return
     */
    List<Goods> getSpxxByLike(String name);
}
