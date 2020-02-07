package com.graduation.serviceImpl;

import com.graduation.dao.VipMapper;
import com.graduation.mode.Vip;
import com.graduation.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VipSeviceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public int insertHy(Vip vip) {
        vipMapper.insertHy(vip);
        return 1;
    }

    @Override
    public int deleteHy(String id) {
        vipMapper.deleteHy(id);
        return 1;
    }

    @Override
    public int updateHy(Vip vip) {
        vipMapper.updateHy(vip);
        return 1;
    }

    @Override
    public List<Vip> getHyxx() {
        List<Vip> list =vipMapper.getHyxx();
        return list;
    }

    @Override
    public List<Vip> selectHyByTel(String tel) {
        List<Vip> list =vipMapper.selectHyByTel(tel);
        return list;
    }
}
