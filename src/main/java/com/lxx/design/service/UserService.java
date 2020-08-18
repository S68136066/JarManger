package com.lxx.design.service;

/**
 * @author：
 * @Date：2020/8/17
 * @Time：17:34
 * @Desc：
 **/
public interface UserService {
    /**
     * 根据用户名查询登密码
     */
    String SigninByPwd(String userid);

}
