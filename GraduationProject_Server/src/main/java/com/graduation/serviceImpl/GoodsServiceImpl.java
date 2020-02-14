package com.graduation.serviceImpl;

import com.graduation.dao.GoodsMapper;
import com.graduation.mode.Goods;
import com.graduation.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void insertSp(Goods goods) {
        goodsMapper.insertSp(goods);
    }

    @Override
    public void deleteSp(String id) {
        goodsMapper.deleteSp(id);
    }

    @Override
    public void updateSp(Goods goods) {
        goodsMapper.updateSp(goods);
    }

    @Override
    public List<Goods> getSpxx() {
        List<Goods> list =goodsMapper.getSpxx();
        return list;
    }

    @Override
    public void updateKcById(String id,Integer number) {
        goodsMapper.updateKcById(id,number);
    }

    @Override
    public List<Goods> getSpxxByLike(String name) {
        List<Goods> list =goodsMapper.getSpxxByLike(name);
        return list;
    }
}
