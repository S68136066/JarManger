package com.lxx.design.dao;

import com.lxx.design.po.sensonr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface sensonrDao extends JpaRepository<sensonr,Integer> {
    /**
     * 查询所有传感器信息
     * @return
     */
    @Transactional
    @Query(value = "select * from sensonr ",nativeQuery = true)
    @Modifying
    List<sensonr> findALLSensonr();
    /**
     * 根据sensonrnum查询
     */
    @Transactional
    @Query(value = "select * from sensonr where sensonrnum = ?",nativeQuery = true)
    @Modifying
    List<sensonr> findSensonerBySensonrnum(Integer sensonrnum);
    /**
     * 删除功能
     */
    @Transactional
    @Query(value = "delete from sensonr where sensonrnum = ?",nativeQuery = true)
    @Modifying
    Integer deletBySensonrnum(Integer sensonrnum);
    /**
     * 修改功能
     */
    @Transactional
    @Query(value = "update sensonr set sensorname = ?,state = ?,com = ? where sensonrnum = ?",nativeQuery = true)
    @Modifying
    Integer updateBySensonrnum(String sensorname,Integer state,String com,Integer sensonrnum);
}
