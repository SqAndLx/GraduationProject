package com.practice.ServiceImpl;

import com.practice.bean.Entity.BeanEntity;
import com.practice.mapper.BeanMapper;
import com.practice.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BeanServiceImpl implements BeanService {

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public List<BeanEntity> getAllBean() {
        return beanMapper.selectAll();
    }
}
