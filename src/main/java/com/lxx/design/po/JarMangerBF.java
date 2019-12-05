package com.lxx.design.po;

import javax.persistence.*;

/**
 * @Author:李兴兴
 * @Date:2019/11/7
 * @Time:10:14
 * @Desc:
 */
@Entity
@Table(name = "jarmangerbf")
public class JarMangerBF {
    //包名称
    private String JarName1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    //需求负责人
    private String Principal1;
    //提交时间
    private String SubTime1;
    //完成时间
    private String FinishTime1;
    //状态
    private String Status1;
    //更新环境
    private String UpEnv1;

    public JarMangerBF(String jarName1, String principal1, String subTime1, String finishTime1, String status1, String upEnv1) {
        JarName1 = jarName1;
        Principal1 = principal1;
        SubTime1 = subTime1;
        FinishTime1 = finishTime1;
        Status1 = status1;
        UpEnv1 = upEnv1;
    }

    public JarMangerBF() {
    }

    public String getJarName1() {
        return JarName1;
    }

    public void setJarName1(String jarName1) {
        JarName1 = jarName1;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPrincipal1() {
        return Principal1;
    }

    public void setPrincipal1(String principal1) {
        Principal1 = principal1;
    }

    public String getSubTime1() {
        return SubTime1;
    }

    public void setSubTime1(String subTime1) {
        SubTime1 = subTime1;
    }

    public String getFinishTime1() {
        return FinishTime1;
    }

    public void setFinishTime1(String finishTime1) {
        FinishTime1 = finishTime1;
    }

    public String getStatus1() {
        return Status1;
    }

    public void setStatus1(String status1) {
        Status1 = status1;
    }

    public String getUpEnv1() {
        return UpEnv1;
    }

    public void setUpEnv1(String upEnv1) {
        UpEnv1 = upEnv1;
    }
}
