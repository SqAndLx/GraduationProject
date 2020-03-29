package com.graduation.dao;

import com.graduation.mode.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PurchaseMapper {

    List<Purchase> getXfxx();
}
