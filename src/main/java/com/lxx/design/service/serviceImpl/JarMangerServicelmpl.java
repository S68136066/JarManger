package com.lxx.design.service.serviceImpl;

import com.lxx.design.dao.JarMangerDao;
import com.lxx.design.po.JarManger;
import com.lxx.design.po.redadmin;
import com.lxx.design.service.JarMangerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:11:11
 * @Desc:
 */
@Service
public class JarMangerServicelmpl implements JarMangerService {
    @Autowired
    private JarMangerDao jd;
    /**@author:李兴兴
      *@desc:查询包内容
      *@param:
      *@return:
      */
    @Override
    public List<JarManger> fingAllJarManger() {
        List<JarManger> list = jd.findAllJarManger();
        if(list != null && list.size()>0){
            return  list;
        }
        return null;
    }
    /**@author:李兴兴
     *@desc:根据需求负责人查询
     *@param:
     *@return:
     */
    @Override
    public List<JarManger> findAllByPrincipal(String Principal) {
        List<JarManger> listPrincipal = jd.findAllByPrincipal(Principal);
        if(listPrincipal != null&& listPrincipal.size()>0){
            return listPrincipal;
        }
        return null;
    }
    /**@author:李兴兴
      *@desc:根据ID查询
      *@param:
      *@return:
      */
    @Override
    public List<JarManger> findJarMangerById(Integer ID) {
        List<JarManger> listById = jd.findJarMangerById(ID);
        if(listById != null && listById.size()>0){
            return listById;
        }
        return new ArrayList<>();
    }
/**@author:李兴兴
  *@desc:修改打包信息
  *@param:
  *@return:
  */
    @Override
    public Boolean updateJarMangerById(String JarName, String Principal, String UpEnv,String SubTime, Integer ID) {
        if (Strings.isEmpty(JarName)){
            return false;
        }
        if (Principal == null){
            return false;
        }
        if (UpEnv == null){
            return false;
        }
        if (ID == null){
            return false;
        }
        Integer integer = jd.updateJarMangerById(JarName,Principal,UpEnv,SubTime,ID);
        if(integer>0){
            return true;
        }
        return false;
    }
/**@author:李兴兴
  *@desc:完成按钮修改状态
  *@param:
  *@return:
  */
    @Override
    public Boolean updateJarMangerStatus(String Status, String FinishTime, Integer ID) {
        Integer integer = jd.updateJarMangerStatus(Status,FinishTime,ID);
        if(integer>0){
            return true;
        }
        return false;
    }
    /**@author:李兴兴
      *@desc:删除功能
      *@param:
      *@return:
      */
    @Override
    public Boolean deleteAllById(Integer ID) {
        Integer integer = jd.deleteAllById(ID);
        if(integer>0){
            return true;
        }
        return false;
    }
/**@author:李兴兴
  *@desc:新增功能
  *@param:
  *@return:
  */
    @Override
    public Boolean AddJarManger(String JarName, String Principal, String SubTime, String UpEnv) {
        Integer integer = jd.AddJarManger(JarName,Principal,SubTime,UpEnv);
        if(integer>0){
            return true;
        }
        return false;
    }


}
