package com.lxx.design.service;

import com.lxx.design.po.JarManger;

import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:11:07
 * @Desc:
 */
public interface JarMangerService {
    /**@author:李兴兴
      *@desc:
      *@param:
      *@return:
      */
    List<JarManger> fingAllJarManger();
    /**@author:李兴兴
      *@desc:根据需求负责人查询
      *@param:
      *@return:
      */
    List<JarManger> findAllByPrincipal(String Principal);
    /**@author:李兴兴
      *@desc:根据ID查询打包信息
      *@param:
      *@return:
      */
    List<JarManger> findJarMangerById(Integer ID);
    /**@author:李兴兴
      *@desc:修改打包信息
      *@param:
      *@return:
      */
    Boolean updateJarMangerById(String JarName,String Principal,String UpEnv,String SubTime, Integer ID);
    /**@author:李兴兴
      *@desc:完成功能主表状态修改
      *@param:
      *@return:
      */
    Boolean updateJarMangerStatus(String Status,String FinishTime,Integer ID);
    /**@author:李兴兴
      *@desc:删除功能实现
      *@param:
      *@return:
      */
    Boolean deleteAllById(Integer ID);
    /**@author:李兴兴
      *@desc:新增功能
      *@param:
      *@return:
      */
    Boolean AddJarManger(String JarName,String Principal,String SubTime,String UpEnv);

}
