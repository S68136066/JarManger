package com.lxx.design.service.serviceImpl;
import com.lxx.design.dao.redadminDao;
import com.lxx.design.po.redadmin;
import com.lxx.design.service.redadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class redadminServiceImpl implements redadminService{
    @Autowired
    private redadminDao rd;

    /**
     * 查询所有红酒温湿度历史信息
     * @return
     */
    @Override
    public List<redadmin> findRedwineAll() {
        List<redadmin> list = rd.findALLRedwine();
        if(list != null && list.size()>0){
            return  list;
        }
        return null;
    }

    /**
     * 删除功能
     * @param rednum
     * @return
     */
    @Override
    public Boolean deletRedHistroyByRednum(Integer rednum) {
        Integer integer = rd.deleteByrednum(rednum);
        if(integer!=null && integer>0){
            return true;
        }
        return false;
    }
    /**
     * 修改功能
     * @param redname
     * @param wendu
     * @param shidu
     * @param totime
     * @param rednum
     * @param sensonrnum
     * @return
     */
    @Override
    public Boolean updataRedHis(String redname, String wendu, String shidu, String totime, Integer sensonrnum, Integer rednum) {
        if(redname == null){
            return  false;
        }
        if(wendu == null){
            return  false;
        }
        if(shidu == null){
            return  false;
        }
        if(totime == null){
            return  false;
        }
        if(sensonrnum == null){
            return false;
        }
        Integer integer = rd.updateRedHisByrednum(redname,wendu,shidu,totime,sensonrnum,rednum);
        if(integer>0){
            return  true;
        }
        return null;
    }
    /**
     * 根据Rednum查询
     * @param rednum
     * @return
     */
    @Override
    public List<redadmin> findRedHisByRednum(Integer rednum) {
      List<redadmin> list = rd.selectByRednum(rednum);
      if(list != null && list.size()>0){
          return list;
      }
        return null;
    }

    @Override
    public List<redadmin> findRedHisByredName(String redname) {
        List<redadmin> list1 = rd.selectByRedName(redname);
        if(list1 != null && list1.size()>0){
            return list1;
        }
        return null;
    }
}
