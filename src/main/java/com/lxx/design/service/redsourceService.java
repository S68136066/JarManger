package com.lxx.design.service;

import com.lxx.design.po.redsource;

import java.util.List;

public interface redsourceService {
    /**
     * 遍历所有红酒信息
     */
    List<redsource> findALLRedsource();

    /**
     * 根据redid查询
     * @param redid
     * @return
     */
    List<redsource> findRedSourceByRedID(Integer redid);
    /**
     * 修改红酒信息
     */
    Boolean updataRedSource(String redname,String sourcearea,String sourceyear,String sourcecompany,Integer redID);
    /**
     * 删除功能
     */
    Boolean deletRedSourceByRedID(Integer redID);
    /**
     * 根据redid查询；搜索功能
     * @param redname
     * @return
     */
    List<redsource> findRedSourceByRedname(String redname);
}
