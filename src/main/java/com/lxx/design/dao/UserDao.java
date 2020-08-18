package com.lxx.design.dao;

import com.lxx.design.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：
 * @Date：2020/8/17
 * @Time：17:20
 * @Desc：
 **/
public interface UserDao extends JpaRepository<User,Integer> {
    /**
     * 根据登录用户查询密码
     */
    @Transactional
    @Query(value = "select password from user where userid = ?",nativeQuery = true)
    String SelectPwdByID(String userid);
}
