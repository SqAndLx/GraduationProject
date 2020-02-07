package com.graduation.serviceImpl;

import com.graduation.dao.TjjeMapper;
import com.graduation.mode.Tjje;
import com.graduation.service.TjjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TjjeServiceImpl implements TjjeService {

    @Autowired
    private TjjeMapper tjjeMapper;

    @Override
    public List<Tjje> getBzt() {
        return tjjeMapper.getBzt();
    }

    @Override
    public List<Tjje> getYlZj() {
        List list = new ArrayList();
        Map<String,Integer> map = new HashMap<>();
        Calendar  cal = Calendar.getInstance();
        int  year = cal.get(Calendar.YEAR);
        int tomYear = year+1;
        Integer total = tjjeMapper.getTotal(year+"-01-01",tomYear+"-01-01");
        //购买商品的盈利金额之和
        Integer ylYsp=tjjeMapper.ylYsp(year+"-01-01",tomYear+"-01-01");
        //无购买商品的盈利金额之和
        Integer ylWsp=tjjeMapper.ylWsp(year+"-01-01",tomYear+"-01-01");
        map.put("total",total);
        map.put("yl",ylYsp+ylWsp);
        list.add(map);
        return list;
    }
}
