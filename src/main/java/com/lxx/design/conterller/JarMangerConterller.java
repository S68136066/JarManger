package com.lxx.design.conterller;

import com.lxx.design.po.JarManger;
import com.lxx.design.po.JarMangerBF;
import com.lxx.design.po.redadmin;
import com.lxx.design.service.JarMangerBFService;
import com.lxx.design.service.JarMangerService;
import com.lxx.design.utils.CrossOriginUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:11:15
 * @Desc:
 */
@Slf4j
@Controller
public class JarMangerConterller {
    @Autowired
    private JarMangerService js;
    @Autowired
    private JarMangerBFService jbfs;
    /**@author：李兴兴
      *@desc:查询打包信息
      *@param:
      *@return:
      */
    @RequestMapping(value = "/findAllJarManger",method = RequestMethod.GET)
    @ResponseBody
    public List<JarManger> findAllredHistory(HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<JarManger> findAll = js.fingAllJarManger();
        return  findAll;
    }
    /**@author:李兴兴
      *@desc:根据需求负责人查询
      *@param:
      *@return:
      */
    @RequestMapping(value = "/findAllByPrincipal",method = RequestMethod.GET)
    @ResponseBody
    public List<JarManger> findAllByPrincipal(@RequestParam String Principal, HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<JarManger> jarMangerListOne = js.findAllByPrincipal(Principal);
        if(jarMangerListOne != null && jarMangerListOne.size()>0){
            return jarMangerListOne;
        }
        return null;
    }
    @RequestMapping(value = "/findJarMangerById",method = RequestMethod.GET)
    @ResponseBody
    public List<JarManger> findJarMangerById(@RequestParam Integer ID,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<JarManger> listJar = js.findJarMangerById(ID);
        return listJar;
    }
    /**@author:李兴兴
      *@desc:修改打包信息
      *@param:
      *@return:
      */
    @RequestMapping(value = "/UpdateJarMangerById",method = RequestMethod.GET)
    @ResponseBody
    public Boolean UpdateJarMangerById(@RequestParam String JarName,@RequestParam String Principal,@RequestParam String UpEnv,@RequestParam String SubTime,@RequestParam Integer ID,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        Boolean aBoolean = js.updateJarMangerById(JarName,Principal,UpEnv,SubTime,ID);
        if (aBoolean){
            return true;
        }
        return false;
    }
    /**@author:李兴兴
      *@desc:备份表迁移
      *@param:
      *@return:
      */
    @RequestMapping(value = "/InsertJBFById",method = RequestMethod.GET)
    @ResponseBody
    public Boolean InsertJBFById(@RequestParam String JarName1, @RequestParam String Principal1, @RequestParam String SubTime1, @RequestParam String FinishTime1, @RequestParam String Status1, @RequestParam String UpEnv1,@RequestParam Integer ID,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        //完成按钮主表状态修改
        Boolean aBoolen1 = js.updateJarMangerStatus(Status1,FinishTime1,ID);
        //主表删除数据 转移
        Boolean aboolean = js.deleteAllById(ID);
        //备份表插入
        JarMangerBF jarMangerBF = new JarMangerBF();
        jarMangerBF.setJarName1(JarName1);
        jarMangerBF.setPrincipal1(Principal1);
        jarMangerBF.setSubTime1(SubTime1);
        jarMangerBF.setFinishTime1(FinishTime1);
        jarMangerBF.setUpEnv1(UpEnv1);
        jarMangerBF.setStatus1(Status1);
        Boolean aBoolen = jbfs.AddJarMangerBF(JarName1,Principal1,SubTime1,FinishTime1,Status1,UpEnv1);
        if(aBoolen && aBoolen1){
            return true;
        }
        return false;
    }
    /**@author:李兴兴
      *@desc:删除功能
      *@param:
      *@return:
      */
    @RequestMapping(value = "/delectJarMangerById",method = RequestMethod.GET)
    @ResponseBody
    public Boolean delectJarMangerById(@RequestParam Integer ID,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        Boolean aboolean = js.deleteAllById(ID);
        if(aboolean){
            return true;
        }
        return false;
    }
    /**@author:李兴兴
      *@desc:新增功能
      *@param:
      *@return:
      */
    @RequestMapping(value = "/AddJarMangerApi",method = RequestMethod.GET)
    @ResponseBody
    public Boolean AddJarMangerApi(@RequestParam String JarName,@RequestParam String Principal,@RequestParam String SubTime,@RequestParam String UpEnv,HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        Boolean aboolen = js.AddJarManger(JarName,Principal,SubTime,UpEnv);
        if(aboolen){
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/FindAllJarMassage",method = RequestMethod.GET)
    @ResponseBody
    public List<JarMangerBF> FindAllJarMassage(HttpServletRequest request, HttpServletResponse response){
        log.info("=================打包历史记录查询开始！=================");
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<JarMangerBF> Listall = jbfs.FindAllJarMassage();
        try {
            if(Listall!=null&&Listall.size()>0){
                log.info("=================打包历史记录查询成功！=================");
                return Listall;
            }
        }catch (Exception e){
                log.error("JarMangerConterller--FindAllJarMassage{" +e.getMessage()+"}");
                return null;
        }
        return null;
    }
}
