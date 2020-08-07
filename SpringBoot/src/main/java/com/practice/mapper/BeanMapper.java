package com.practice.mapper;


import com.practice.bean.Entity.ExampleEntity;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BeanMapper extends Mapper<ExampleEntity> {

}
