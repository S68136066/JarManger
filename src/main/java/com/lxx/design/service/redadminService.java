package com.lxx.design.service;

import java.util.List;
import com.lxx.design.po.redadmin;
public interface redadminService {
    /**
     * 遍历所有红酒温湿度历史记录
     */
    List<redadmin> findRedwineAll();
    /**
     * 删除功能
     */
    Boolean deletRedHistroyByRednum(Integer rednum);
    /**
     * 修改功能
     */
    Boolean updataRedHis (String redname,String wendu,String shidu,String totime,Integer sensonrnum, Integer rednum);
    /**
     * 查询根据RedNUM
     */
    List<redadmin> findRedHisByRednum(Integer rednum);
    /**
     * 搜索功能
     * 根据红酒名字
     */
    List<redadmin> findRedHisByredName(String redname);
}
