package com.lxx.design.po;

import javax.persistence.*;

/**
 * @author：LIxx
 * @Date：2020/8/17
 * @Time：16:47
 * @Desc：
 **/
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * userid
     */
    private String userid;
    /**
     * password
     */
    private String password;
    /**
     * grade
     */
    private String grade;

    public User(String userid, String password, String grade) {
        this.userid = userid;
        this.password = password;
        this.grade = grade;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
