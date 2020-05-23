package com.graduation.service;

import com.graduation.mode.Yuyue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface YuyueService {

    void insertYy(Yuyue yy);

    List<Yuyue> getYy(String name);

    void deleteYy(String name);

    List<Yuyue> getAll();
}
