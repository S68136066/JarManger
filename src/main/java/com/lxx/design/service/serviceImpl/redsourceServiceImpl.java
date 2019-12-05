package com.lxx.design.service.serviceImpl;

import com.lxx.design.dao.redsourceDao;
import com.lxx.design.po.redsource;
import com.lxx.design.service.redsourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class redsourceServiceImpl implements redsourceService {
    @Autowired
    private redsourceDao rsd;
    /**
     * 遍历所有红酒信息
     * @return
     */
    @Override
    public List<redsource> findALLRedsource() {
        List<redsource> allRedsource = rsd.findALLRedsource();
        if(allRedsource != null && allRedsource.size()>0){
            return  allRedsource;
        }
        return null;
    }

    /**
     * 根据redid查询
     * @param redid
     * @return
     */
    @Override
    public List<redsource> findRedSourceByRedID(Integer redid) {
        List<redsource> list = rsd.selectRedSourceByRedID(redid);
        if(list != null && list.size()>0){
            return list;
        }
        return null;
    }

    /**
     * 修改红酒信息根据RedID
     * @param redname
     * @param sourcearea
     * @param sourceyear
     * @param sourcecompany
     * @param redID
     * @return
     */
    @Override
    public Boolean updataRedSource(String redname, String sourcearea, String sourceyear, String sourcecompany, Integer redID) {
        if(redname == null){
            return false;
        }
        if(sourcearea == null){
            return false;
        }
        if(sourceyear == null){
            return false;
        }
        if(sourcecompany == null){
            return false;
        }
        Integer integer = rsd.updataRedSourceByRedID(redname,sourcearea,sourceyear,sourcecompany,redID);
        if(integer>0){
            return true;
        }
        return null;
    }

    /**
     * 删除功能
     * @param redID
     * @return
     */
    @Override
    public Boolean deletRedSourceByRedID(Integer redID) {
        Integer integer = rsd.deleteByRedID(redID);
        if(integer != null && integer>0){
            return true;
        }
        return false;
    }

    /**
     * 搜索功能
     * @param redname
     * @return
     */
    @Override
    public List<redsource> findRedSourceByRedname(String redname) {
        List<redsource> list = rsd.selectRedSourceByRedname(redname);
        if(list != null && list.size()>0){
            return list;
        }
        return null;
    }
}
