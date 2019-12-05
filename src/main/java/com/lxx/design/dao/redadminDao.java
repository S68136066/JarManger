package com.lxx.design.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lxx.design.po.redadmin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface redadminDao extends JpaRepository<redadmin,Integer>{
    /**
     * 遍历所有红酒温湿度历史记录
     */
    @Transactional
    @Query(value = "SELECT * from redadmin",nativeQuery = true)
    @Modifying
    List<redadmin> findALLRedwine();
    /**
     * 删除功能
     */
    @Transactional
    @Query(value = "DELETE from redadmin where rednum = ?",nativeQuery = true)
    @Modifying
    Integer deleteByrednum(Integer rednum);
    /**
     * 修改功能
     */
    @Transactional
    @Query(value = "update redadmin set redname= ? ,wendu = ?,shidu = ?,totime = ?,sensonrnum = ?  where rednum = ?",nativeQuery = true)
    @Modifying
    Integer updateRedHisByrednum(String redname,String wendu,String shidu,String totime,Integer sensonrnum,Integer rednum);
    /**
     * 根据Rednum查询
     * 修改时使用
     */
    @Transactional
    @Query(value = "select * from redadmin where rednum = ?",nativeQuery = true)
    @Modifying
     List<redadmin> selectByRednum(Integer rednum);
    /**
     * 搜索功能
     */
    @Transactional
    @Query(value = "select * from redadmin where redname = ?",nativeQuery = true)
    @Modifying
    List<redadmin> selectByRedName(String redname);
}
