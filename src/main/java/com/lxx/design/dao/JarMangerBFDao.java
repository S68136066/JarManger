package com.lxx.design.dao;

import com.lxx.design.po.JarMangerBF;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import javax.transaction.Transactional;

/**
 * @Author:李兴兴
 * @Date:2019/11/7
 * @Time:10:19
 * @Desc:
 */
@Repository
public interface JarMangerBFDao extends JpaRepository<JarMangerBF,Integer>,JpaSpecificationExecutor<JarMangerBF> {

    /**@author:李兴兴
      *@desc:完成按钮实现
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "insert into jarmangerbf(JarName1,Principal1,SubTime1,FinishTime1,Status1,UpEnv1) values(?1,?2,?3,?4,?5,?6) ",nativeQuery = true )
    @Modifying
    Integer AddJarMangerBF(String JarName1,String Principal1,String SubTime1,String FinishTime1,String Status1,String UpEnv1);
}
