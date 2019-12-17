package com.lxx.design.service;

import com.lxx.design.po.JarMangerBF;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/7
 * @Time:13:45
 * @Desc:
 */
public interface JarMangerBFService {
    /**@author:李兴兴
      *@desc:完成按钮实现打包表迁移到备份表
      *@param:
      *@return:
      */
    Boolean AddJarMangerBF(String JarName1,String Principal1,String SubTime1,String FinishTime1,String Status1,String UpEnv1);
    /**@author:李兴兴
     *@desc:查询历史记录
     *@param:
     *@return:
     */
    List<JarMangerBF> FindAllJarMassage();
}

