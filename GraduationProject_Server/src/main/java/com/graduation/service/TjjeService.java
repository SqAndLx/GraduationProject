package com.graduation.service;

import com.graduation.mode.Tjje;
import java.util.List;

public interface TjjeService {

    /**
     * 获取饼状图数据
     * @return
     */
    List<Tjje> getBzt();

    /**
     * 当前年份盈利和总计
     * @return
     */
    List<Tjje> getYlZj();
    /**
     * 前5个月盈利和总计
     * @return
     */
    List<Tjje> getYYlZj();
}
