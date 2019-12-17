package com.lxx.design.service.serviceImpl;

import com.lxx.design.dao.JarMangerBFDao;
import com.lxx.design.po.JarMangerBF;
import com.lxx.design.service.JarMangerBFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/7
 * @Time:15:32
 * @Desc:
 */
@Service
public class JarMangerBFServicelmpl implements JarMangerBFService {
    @Autowired
    private JarMangerBFDao jbfd;
    /**@author:李兴兴
      *@desc:完成按钮功能
      *@param:
      *@return:
      */
    @Override
    public Boolean AddJarMangerBF(String JarName1,String Principal1,String SubTime1,String FinishTime1,String Status1,String UpEnv1) {
        Integer integer = jbfd.AddJarMangerBF(JarName1,Principal1,SubTime1,FinishTime1,Status1,UpEnv1);
        if(integer>0){
            return true;
        }
        return false;
    }
    /**@author:李兴兴
     *@desc:查询历史记录
     *@param:
     *@return:
     */
    @Override
    public List<JarMangerBF> FindAllJarMassage() {
        List<JarMangerBF> allList = jbfd.findAllByall();
        if(allList!= null && allList.size()>0){
            return allList;
        }
        return new ArrayList<>();
    }
}
