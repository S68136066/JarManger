package com.lxx.design.po;

import javax.persistence.*;

@Entity
@Table(name = "redsource")
public class redsource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer redID;
    @Column
    private  String redname;
    @Column
    private  String sourcearea;
    @Column
    private  String sourceyear;
    @Column
    private  String sourcecompany;

    public redsource(Integer redID, String redname, String sourcearea, String sourceyear, String sourcecompany) {
        this.redID = redID;
        this.redname = redname;
        this.sourcearea = sourcearea;
        this.sourceyear = sourceyear;
        this.sourcecompany = sourcecompany;
    }

    public redsource() {
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

    public String getSourcearea() {
        return sourcearea;
    }

    public void setSourcearea(String sourcearea) {
        this.sourcearea = sourcearea;
    }

    public String getSourceyear() {
        return sourceyear;
    }

    public void setSourceyear(String sourceyear) {
        this.sourceyear = sourceyear;
    }

    public String getSourcecompany() {
        return sourcecompany;
    }

    public void setSourcecompany(String sourcecompany) {
        this.sourcecompany = sourcecompany;
    }
}
