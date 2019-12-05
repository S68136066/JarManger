package com.lxx.design.conterller;

import com.lxx.design.po.PrincipalManger;
import com.lxx.design.service.PrincipalMangerService;
import com.lxx.design.utils.CrossOriginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:20:05
 * @Desc:
 */
@Controller
public class PrincipalMangerConterller {
    @Autowired
    private PrincipalMangerService ps;
    /**@author:李兴兴
      *@desc:查询需求负责人
      *@param:
      *@return:
      */
    @RequestMapping(value = "/findAllPrincipal",method = RequestMethod.GET)
    @ResponseBody
    public List<PrincipalManger> findAllPrincipal(HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<PrincipalManger> findAll = ps.findAllPrincipal();
        return findAll;
    }
}
