package com.lxx.design.dao;

import com.lxx.design.po.redsource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface redsourceDao extends JpaRepository<redsource,Integer> {
    /**
     * 遍历所有红酒信息
     */
    @Transactional
    @Query(value = "select * from redsource ",nativeQuery = true)
    @Modifying
    List<redsource> findALLRedsource();
    /**
     * 根据Rednum查询
     * 修改时使用
     */
    @Transactional
    @Query(value = "select * from redsource where redID = ?",nativeQuery = true)
    @Modifying
    List<redsource> selectRedSourceByRedID(Integer redid);
    /**
     * 修改红酒信息
     */
    @Transactional
    @Query(value = "update redsource set redname = ?,sourcearea = ?,sourceyear = ?,sourcecompany = ? where redID = ?",nativeQuery = true)
    @Modifying
    Integer updataRedSourceByRedID(String redname,String sourcearea,String sourceyear,String sourcecompany,Integer redID);
    /**
     * 删除功能
     */
    @Transactional
    @Query(value = "delete from redsource where redID=?",nativeQuery = true)
    @Modifying
    Integer deleteByRedID(Integer redID);
    /**
     * 根据Redname查询
     * 搜索功能
     */
    @Transactional
    @Query(value = "select * from redsource where redname = ?",nativeQuery = true)
    @Modifying
    List<redsource> selectRedSourceByRedname(String redname);
}
