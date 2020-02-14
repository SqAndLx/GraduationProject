package com.graduation.dao;

import com.graduation.mode.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    /**
     * 新增商品
     */
    void insertSp(Goods goods);

    /**
     * 删除商品
     */
    @Delete("DELETE FROM goods WHERE c_id = #{id}")
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
    void updateKcById(@Param("id") String id,@Param("number") Integer number);

    /**
     * 模糊查询商品信息
     * @param name
     * @return
     */
    List<Goods> getSpxxByLike(@Param("name") String name);
}
