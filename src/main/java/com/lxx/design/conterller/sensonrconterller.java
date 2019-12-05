package com.lxx.design.conterller;

import com.lxx.design.po.sensonr;
import com.lxx.design.service.sensonrService;
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
public class sensonrconterller {
    @Autowired
    private sensonrService ss;

    /**
     * 遍历所有传感器信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/findAllSensonr",method = RequestMethod.GET)
    @ResponseBody
    public List<sensonr> findAllSensonrOne(HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<sensonr> sensonrsList = ss.SelerAllSenonr();
        return sensonrsList;
    }

    /**
     *查询根据sensonrnum
     * @param sensonrnum
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/findSensonrByNum",method = RequestMethod.GET)
    @ResponseBody
    public List<sensonr> findSensonrByNumOne(@RequestParam Integer sensonrnum,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<sensonr> listByNum =ss.SeletSensonrByNum(sensonrnum);
        return listByNum;
    }

    /**
     * 删除功能
     * @param sensonrnum
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/deletSensonrByNum",method = RequestMethod.GET)
    @ResponseBody
    public Boolean deletSensonrByNumOne(@RequestParam Integer sensonrnum,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        Boolean aBooleanOne = ss.DeletSensonrBynum(sensonrnum);
        if(aBooleanOne){
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/updateSensonrByNum",method = RequestMethod.GET)
    @ResponseBody
    public Boolean updateSensonrByNumOne(@RequestParam String sensorname,@RequestParam Integer state,@RequestParam String com,@RequestParam Integer sensonrnum,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        Boolean bboolean =  ss.updateSensonrByNum(sensorname,state,com,sensonrnum);
        if(bboolean){
            return true;
        }
        return false;
    }
}
