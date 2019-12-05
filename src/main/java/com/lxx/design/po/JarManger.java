package com.lxx.design.po;

import javax.persistence.*;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:10:38
 * @Desc:
 */
@Entity
@Table(name = "jarmanger")
public class JarManger {
    //包名称
    private String JarName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    //需求负责人
    private String Principal;
    //提交时间
    private String SubTime;
    //完成时间
    private String FinishTime;
    //状态
    private String Status;
    //更新环境
    private String UpEnv;

    public JarManger(String jarName, String principal, String subTime, String finishTime, String status, String upEnv) {
        JarName = jarName;
        Principal = principal;
        SubTime = subTime;
        FinishTime = finishTime;
        Status = status;
        UpEnv = upEnv;
    }

    public JarManger() {
    }

    public String getJarName() {
        return JarName;
    }

    public void setJarName(String jarName) {
        JarName = jarName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPrincipal() {
        return Principal;
    }

    public void setPrincipal(String principal) {
        Principal = principal;
    }

    public String getSubTime() {
        return SubTime;
    }

    public void setSubTime(String subTime) {
        SubTime = subTime;
    }

    public String getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(String finishTime) {
        FinishTime = finishTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUpEnv() {
        return UpEnv;
    }

    public void setUpEnv(String upEnv) {
        UpEnv = upEnv;
    }
}
