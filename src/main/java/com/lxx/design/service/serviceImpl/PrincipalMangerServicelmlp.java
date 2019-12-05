package com.lxx.design.service.serviceImpl;

import com.lxx.design.dao.PrincipalMangerDao;
import com.lxx.design.po.PrincipalManger;
import com.lxx.design.service.PrincipalMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:20:01
 * @Desc:
 */
@Service
public class PrincipalMangerServicelmlp implements PrincipalMangerService {
    @Autowired
    private PrincipalMangerDao pd;
    /**@author:李兴兴
      *@desc:查询需求负责人
      *@param:
      *@return:
      */
    @Override
    public List<PrincipalManger> findAllPrincipal() {
        List<PrincipalManger> list = pd.findAllPrincipal();
        if(list != null && list.size()>0){
            return list;
        }
        return null;
    }
}
