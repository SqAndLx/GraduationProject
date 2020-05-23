package com.graduation.serviceImpl;

import com.graduation.dao.RechargeMapper;
import com.graduation.dao.YuyueMapper;
import com.graduation.mode.Yuyue;
import com.graduation.service.YuyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YuyueServiceImpl implements YuyueService {

    @Autowired
    private YuyueMapper YuyueMapper;


    @Override
    public void insertYy(Yuyue yy) {
        YuyueMapper.insertYy(yy);
    }

    @Override
    public List<Yuyue> getYy(String name) {
        return YuyueMapper.getYy(name);
    }

    @Override
    public void deleteYy(String name) {
        YuyueMapper.deleteYy(name);
    }

    @Override
    public List<Yuyue> getAll() {
        return YuyueMapper.getAll();
    }
}
