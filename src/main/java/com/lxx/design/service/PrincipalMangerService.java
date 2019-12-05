package com.lxx.design.service;

import com.lxx.design.po.PrincipalManger;

import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:20:00
 * @Desc:
 */
public interface PrincipalMangerService {
    /**@author:李兴兴
      *@desc:查询需求负责人
      *@param:
      *@return:
      */
    List<PrincipalManger> findAllPrincipal();
}
