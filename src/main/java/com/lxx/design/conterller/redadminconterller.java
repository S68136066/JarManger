package com.lxx.design.conterller;

import com.lxx.design.po.redadmin;
import com.lxx.design.po.redsource;
import com.lxx.design.service.redadminService;

import com.lxx.design.utils.CrossOriginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class redadminconterller {
    @Autowired
    private redadminService rs;
    @RequestMapping(value = "/findAllredWine",method = RequestMethod.GET)
    @ResponseBody
    public List<redadmin> findAllredHistory(HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<redadmin> redwineAll = rs.findRedwineAll();
        return  redwineAll;
    }
    /**
     * 删除操作
     * @param rednum
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/deletRedHis",method = RequestMethod.GET)
    @ResponseBody
    public Boolean deletRedHistroy(@RequestParam Integer rednum,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        if(rednum == null){
            return false;
        }
        Boolean aBoolean = rs.deletRedHistroyByRednum(rednum);
        if(aBoolean){
            return true;
        }
        return  false;
    }

    /**
     * 修改功能
     * @param redname
     * @param wendu
     * @param shidu
     * @param totime
     * @param rednum
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateRedHistroyByRednumss",method = RequestMethod.GET)
    @ResponseBody
    public Boolean updateRedHisByRednum(@RequestParam String redname,@RequestParam String wendu,@RequestParam String shidu,@RequestParam String totime,@RequestParam Integer sensonrnum,@RequestParam Integer rednum,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        Boolean aBoolean = rs.updataRedHis(redname,wendu,shidu,totime,sensonrnum,rednum);
        if(aBoolean){
            return true;
        }
        return false;
    }

    /**
     * 根据Rednum查询
     * @return
     */
    @RequestMapping(value = "/findRedHisByRednum",method = RequestMethod.GET)
    @ResponseBody
    public List<redadmin> findRedHisByRednum(@RequestParam Integer rednum,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<redadmin> list = rs.findRedHisByRednum(rednum);
        return list;
    }

    /**
     * 搜索功能
     * @param redname
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/findRedHisByRedname",method = RequestMethod.GET)
    @ResponseBody
    public List<redadmin> findRedHisByRednameOne(@RequestParam String redname,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<redadmin> redHisByredName = rs.findRedHisByredName(redname);

        return redHisByredName;
    }
}
