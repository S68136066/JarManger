package com.lxx.design.service.serviceImpl;

import com.lxx.design.dao.sensonrDao;
import com.lxx.design.po.sensonr;
import com.lxx.design.service.sensonrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class sensonrServiceImpl implements sensonrService {
    @Autowired
    private sensonrDao sd;
    /**
     * 遍历所有传感器信息
     * @return
     */
    @Override
    public List<sensonr> SelerAllSenonr() {
        List<sensonr> allSensonr = sd.findALLSensonr();
        if(allSensonr != null &&allSensonr.size()>0){
            return allSensonr;
        }
        return null;
    }

    /**
     * 查询根据Num
     * @param sensonrnum
     * @return
     */
    @Override
    public List<sensonr> SeletSensonrByNum(Integer sensonrnum) {
        List<sensonr> sensonerBySensonrnum = sd.findSensonerBySensonrnum(sensonrnum);
        if(sensonerBySensonrnum != null && sensonerBySensonrnum.size()>0){
            return sensonerBySensonrnum;
        }
        return null;
    }

    /**
     * 删除功能
     * @param sensonrnum
     * @return
     */
    @Override
    public Boolean DeletSensonrBynum(Integer sensonrnum) {

        Integer integer = sd.deletBySensonrnum(sensonrnum);
        if(sensonrnum != null && integer>0){
            return true;
        }
        return false;
    }

    /**
     *修改功能
     * @param sensorname
     * @param state
     * @param com
     * @param sensonrnum
     * @return
     */
    @Override
    public Boolean updateSensonrByNum(String sensorname, Integer state, String com, Integer sensonrnum) {
        if(sensorname == null){
            return false;
        }
        if(state == null){
            return false;
        }
        if(com == null){
            return false;
        }
       Integer aboolean =  sd.updateBySensonrnum(sensorname,state,com,sensonrnum);
       if(aboolean>0){
           return true;
       }
        return null;
    }
}
