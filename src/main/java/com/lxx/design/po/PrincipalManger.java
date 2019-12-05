package com.lxx.design.po;

import javax.persistence.*;

/**
 * @Author:李兴兴
 * @Date:2019/11/5
 * @Time:19:31
 * @Desc:
 */
@Entity
@Table(name = "PrincipalManger")
public class PrincipalManger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Pid;
    //负责人姓名
    private String PName;

    public PrincipalManger(String PName) {
        this.PName = PName;
    }

    public PrincipalManger() {
    }

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        Pid = pid;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }
}
