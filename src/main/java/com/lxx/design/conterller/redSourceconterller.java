package com.lxx.design.conterller;
import com.lxx.design.po.redsource;
import com.lxx.design.service.redsourceService;
import com.lxx.design.utils.CrossOriginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class redSourceconterller {
    @Autowired
    private redsourceService rss;
    @RequestMapping(value = "/findAllRedSource",method = RequestMethod.GET)
    @ResponseBody
    public List<redsource> findAllRedSourceOne(HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<redsource> list = rss.findALLRedsource();
        return  list;
    }

    /**
     * 根据RedID查询
     * @param redID
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/findredSourceByRedid",method = RequestMethod.GET)
    @ResponseBody
    public List<redsource> findredSourceByRedidTow(@RequestParam Integer redID, HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<redsource> redSourceByRedIDList = rss.findRedSourceByRedID(redID);
        return redSourceByRedIDList;
    }

    /**
     * 修改红酒信息
     * @param redname
     * @param sourcearea
     * @param sourceyear
     * @param sourcecompany
     * @param redID
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updataRedSource",method = RequestMethod.GET)
    @ResponseBody
    public Boolean updataRedSourceThree(@RequestParam String redname,@RequestParam String sourcearea,@RequestParam String sourceyear,@RequestParam String sourcecompany,@RequestParam Integer redID,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        Boolean iboolean = rss.updataRedSource(redname,sourcearea,sourceyear,sourcecompany,redID);
        if(iboolean){
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/deletRedSourByRedID",method = RequestMethod.GET)
    @ResponseBody
    public Boolean deletRedSourByRedIDOne(@RequestParam Integer redID,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        if(redID == null){
            return false;
        }
        Boolean integer = rss.deletRedSourceByRedID(redID);
        if(integer){
            return true;
        }
        return false;
    }
    /**
     * 根据RedID查询
     * @param redname
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/findredSourceByRedname",method = RequestMethod.GET)
    @ResponseBody
    public List<redsource> findredSourceByRednameOne(@RequestParam String redname, HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<redsource> redSourceByRedNameList = rss.findRedSourceByRedname(redname);
        return redSourceByRedNameList;
    }
}
