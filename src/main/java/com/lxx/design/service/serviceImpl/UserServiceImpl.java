package com.lxx.design.service.serviceImpl;

import com.lxx.design.dao.UserDao;
import com.lxx.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：
 * @Date：2020/8/17
 * @Time：17:37
 * @Desc：
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired

    private UserDao ud;

    @Override
    public String SigninByPwd(String userid) {
        String paw = ud.SelectPwdByID(userid);
          if(paw!=null && paw!=""){
              return paw;
          }
        return null;
    }
}
