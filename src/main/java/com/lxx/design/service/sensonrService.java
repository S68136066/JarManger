package com.lxx.design.service;

import com.lxx.design.po.sensonr;

import java.util.List;

public interface sensonrService {
    /**
     * 遍历传感器信息
     */
    List<sensonr> SelerAllSenonr();
    /**
     * 查询传感器信息根据Num
     */
    List<sensonr> SeletSensonrByNum(Integer sensonrnum);
    /**
     * 删除功能
     */
    Boolean DeletSensonrBynum(Integer sensonrnum);
    /**
     * 修改功能
     */
    Boolean updateSensonrByNum(String sensorname,Integer state,String com,Integer sensonrnum);
}
