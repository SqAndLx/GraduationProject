package com.graduation.serviceImpl;

import com.graduation.dao.TjjeMapper;
import com.graduation.mode.Tjje;
import com.graduation.service.TjjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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

    @Override
    public List<Tjje> getYYlZj() {
        List list = new ArrayList();
        Calendar  cal = Calendar.getInstance();
        DecimalFormat df=new DecimalFormat("00");
        int  year = cal.get(Calendar.YEAR);
        int  month = cal.get(Calendar.MONTH) + 1;
        int tomYear = year;
        int tomMonth = month+1;
        for(int i = 0; i < 5; i++){
            String a = year+"-"+df.format(month)+"-01";
            String b = tomYear+"-"+df.format(tomMonth)+"-01";
            Map<String,Integer> map = new HashMap<>();
            Integer total = tjjeMapper.getTotal(year+"-"+df.format(month)+"-01",tomYear+"-"+df.format(tomMonth)+"-01");
            //购买商品的盈利金额之和
            Integer ylYsp=tjjeMapper.ylYsp(year+"-"+df.format(month)+"-01",tomYear+"-"+df.format(tomMonth)+"-01");
            //无购买商品的盈利金额之和
            Integer ylWsp=tjjeMapper.ylWsp(year+"-"+df.format(month)+"-01",tomYear+"-"+df.format(tomMonth)+"-01");
            map.put("total",total);
            map.put("yl",ylYsp+ylWsp);
            list.add(map);
            tomMonth=month;
            tomYear=year;
            if(month == 1){
                year = year-1;
                month = 12;
            }else {
                month--;
            }
        }
        return list;
    }
}
