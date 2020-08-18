package com.lxx.design.conterller;

import com.lxx.design.service.UserService;
import com.lxx.design.utils.CrossOriginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：
 * @Date：2020/8/17
 * @Time：17:41
 * @Desc：
 **/
@Slf4j
@Controller
public class UserSiginConterller {

    @Autowired

    private UserService us;

    /**
     * 登录功能
     * @param userid
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "login/SiginByPaw",method = RequestMethod.POST)
    @ResponseBody
    public Boolean SiginByPaw(@RequestParam String userid,@RequestParam String password, HttpServletRequest request, HttpServletResponse response){
        log.info("用户："+userid+"进行登录");
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        String Turnpassword = us.SigninByPwd(userid);
        if(password != null && password !=""){
            if(Turnpassword.equals(password)){
                log.info("用户："+userid+"登录成功！");
                return true;
            }
        }
        log.info("用户："+userid+"登录失败！密码不正确或账号不存在");
        return false;

    }



}
