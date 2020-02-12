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
    public int insertSp(Goods goods) {
        goodsMapper.insertSp(goods);
        return 1;
    }

    @Override
    public int deleteSp(String id) {
        goodsMapper.deleteSp(id);
        return 1;
    }

    @Override
    public int updateSp(Goods goods) {
        goodsMapper.updateSp(goods);
        return 1;
    }

    @Override
    public List<Goods> getSpxx() {
        List<Goods> list =goodsMapper.getSpxx();
        return list;
    }

    @Override
    public int updateKcById(String id,Integer number) {
        goodsMapper.updateKcById(id,number);
        return 1;
    }

    @Override
    public List<Goods> getSpxxByLike(String name) {
        List<Goods> list =goodsMapper.getSpxxByLike(name);
        return list;
    }
}
