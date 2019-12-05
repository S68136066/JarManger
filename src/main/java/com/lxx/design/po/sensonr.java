package com.lxx.design.po;

import javax.persistence.*;

@Entity
@Table(name = "sensonr")
public class sensonr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sensonrnum;
    @Column
    private String sensorname;
    @Column
    private String com;
    @Column
    private Integer state;

    public sensonr(Integer sensonrnum, String sensorname, String com, Integer state) {
        this.sensonrnum = sensonrnum;
        this.sensorname = sensorname;
        this.com = com;
        this.state = state;
    }

    public sensonr() {
    }

    public Integer getSensonrnum() {
        return sensonrnum;
    }

    public void setSensonrnum(Integer sensonrnum) {
        this.sensonrnum = sensonrnum;
    }

    public String getSensorname() {
        return sensorname;
    }

    public void setSensorname(String sensorname) {
        this.sensorname = sensorname;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
