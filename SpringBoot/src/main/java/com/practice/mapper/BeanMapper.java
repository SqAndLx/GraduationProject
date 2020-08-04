package com.practice.mapper;


import com.practice.bean.Entity.BeanEntity;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BeanMapper extends Mapper<BeanEntity> {

}
