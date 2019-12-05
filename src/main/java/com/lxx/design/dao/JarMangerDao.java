package com.lxx.design.dao;

import com.lxx.design.po.JarManger;
import org.apache.tomcat.Jar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Autho:李兴兴
 * @Date:2019/11/5
 * @Time:10:59
 * @Desc:
 */
public interface JarMangerDao extends JpaRepository<JarManger,Integer> {
    /**@author:李兴兴
      *@desc:查询提交包内容
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "select * from Jarmanger ",nativeQuery = true)
    @Modifying
    List<JarManger> findAllJarManger();
    /**@author:李兴兴
      *@desc:根据需求负责人搜索
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "select * from Jarmanger where Principal = ?",nativeQuery = true)
    @Modifying
    List<JarManger> findAllByPrincipal(String Principal);

    /**@author:李兴兴
      *@desc:根据ID查询打包信息
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "SELECT * from JarManger where ID = ?",nativeQuery = true)
    @Modifying
    List<JarManger> findJarMangerById(Integer ID);
    /**@author:李兴兴
      *@desc:打包信息修改功能
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "update JarManger set JarName = ? ,Principal = ?, UpEnv = ?,SubTime = ? where ID = ?",nativeQuery = true)
    @Modifying
    Integer updateJarMangerById(String JarName,String Principal,String UpEnv,String SubTime, Integer ID);
    /**@author:李兴兴
      *@desc:完成功能主表状态修改
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "update JarManger set Status = ?,FinishTime = ? where ID = ?",nativeQuery = true)
    @Modifying
    Integer updateJarMangerStatus(String Status,String FinishTime,Integer ID);

    /**@author:李兴兴
      *@desc:删除功能
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "DELETE from JarManger where ID = ?",nativeQuery = true)
    @Modifying
    Integer deleteAllById(Integer ID);
    /**@author:李兴兴
      *@desc:新增打包信息
      *@param:
      *@return:
      */
    @Transactional
    @Query(value = "insert into JarManger(JarName,Principal,SubTime,UpEnv) values(?1,?2,?3,?4)",nativeQuery = true)
    @Modifying
    Integer AddJarManger(String JarName,String Principal,String SubTime,String UpEnv);
}
