package com.graduation.serviceImpl;

import com.graduation.dao.TjjeMapper;
import com.graduation.mode.Tjje;
import com.graduation.service.TjjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TjjeServiceImpl implements TjjeService {

    @Autowired
    private TjjeMapper tjjeMapper;

    @Override
    public List<Tjje> getBzt() {
        return tjjeMapper.getBzt();
    }
}
