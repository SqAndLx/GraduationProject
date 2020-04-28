package com.graduation.serviceImpl;

import com.graduation.dao.VipMapper;
import com.graduation.mode.Vip;
import com.graduation.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class VipSeviceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public void insertHy(Vip vip) {
        vipMapper.insertHy(vip);
    }

    @Override
    public void deleteHy(String id) {
        vipMapper.deleteHy(id);
    }

    @Override
    public void updateHy(Vip vip) {
        vipMapper.updateHy(vip);
    }

    @Override
    public List<Vip> getHyxx() {
        List<Vip> list =vipMapper.getHyxx();
        list.sort(Comparator.comparing(Vip::getIntegral).reversed());
        return list;
    }

    @Override
    public Vip selectHyByTel(String tel) {
        Vip vip = vipMapper.selectHyByTel(tel);
        return vip;
    }

    @Override
    public List<Vip> selectHyByZd(String zd, String valu) {
        List<Vip> list =vipMapper.selectHyByZd(zd,valu);
        return list;
    }

}
