package com.lxx.design.dao;

import com.lxx.design.po.PrincipalManger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:19:34
 * @Desc:
 */
public interface PrincipalMangerDao extends JpaRepository<PrincipalManger,Integer> {
    /**@author:李兴兴
      *@desc:查询需求负责人
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "select * from PrincipalManger",nativeQuery = true)
    @Modifying
    List<PrincipalManger> findAllPrincipal();
}
