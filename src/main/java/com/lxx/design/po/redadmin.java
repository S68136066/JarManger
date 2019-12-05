package com.lxx.design.po;

import javax.persistence.*;

@Entity
@Table(name = "redadmin")
public class redadmin {
    /**
     * 列表编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rednum;
    /**
     * 红酒ID
     */
    @Column
    private Integer redID;
    /**
     * 红酒名字
     */
    @Column
    private  String redname;
    /**
     * 温度
     */
    @Column
    private  String wendu;
    /**
     * 红酒湿度
     */
    @Column
    private  String shidu;
    /**
     * 检测时间
     */
    @Column
    private  String Totime;
    @Column
    /**
     * 设备号
     */
    private  Integer sensonrnum;

    public redadmin(Integer redID, String redname, String wendu, String shidu, String totime, Integer sensonrnum) {
        this.redID = redID;
        this.redname = redname;
        this.wendu = wendu;
        this.shidu = shidu;
        Totime = totime;
        this.sensonrnum = sensonrnum;
    }

    public redadmin() {

    }

    public Integer getRednum() {
        return rednum;
    }

    public void setRednum(Integer rednum) {
        this.rednum = rednum;
    }

    public Integer getRedID() {
        return redID;
    }

    public void setRedID(Integer redID) {
        this.redID = redID;
    }

    public String getRedname() {
        return redname;
    }

    public void setRedname(String redname) {
        this.redname = redname;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public String getTotime() {
        return Totime;
    }

    public void setTotime(String totime) {
        Totime = totime;
    }

    public Integer getSensonrnum() {
        return sensonrnum;
    }

    public void setSensonrnum(Integer sensonrnum) {
        this.sensonrnum = sensonrnum;
    }
}
