package com.graduation.dao;

import com.graduation.mode.Vip;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface VipMapper {

    void insertHy(Vip vip);

    @Delete("DELETE FROM vip WHERE c_id = #{id}")
    void deleteHy(@Param("id") String id);

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
    List<Vip> selectHyByZd(@Param("zd")String zd,@Param("valu")String valu);

    Vip selectHybyId(@Param("id")String id);
}
