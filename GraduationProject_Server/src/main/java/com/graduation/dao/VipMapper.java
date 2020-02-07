package com.graduation.dao;

import com.graduation.mode.Vip;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface VipMapper {

    int insertHy(Vip vip);

    @Delete("DELETE FROM vip WHERE c_id = #{id}")
    int deleteHy(@Param("id") String id);

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
