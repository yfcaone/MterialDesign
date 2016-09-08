package com.example.aone.navigationview_01.domain;

/**
 * Created by aone on 2016/8/2.
 */
public class CInfo {

    /**
     * Cno : 1
     * Cname : zhang
     * Cnun : 12
     */

    private int Cno;
    private String Cname;
    private int Cnun;

    public CInfo() {
    }

    public CInfo(int cnun, String cname) {
        Cnun = cnun;
        Cname = cname;
    }

    @Override
    public String toString() {
        return "CInfo{" +
                "Cno=" + Cno +
                ", Cname='" + Cname + '\'' +
                ", Cnun=" + Cnun +
                '}';
    }

    public int getCno() {
        return Cno;
    }

    public void setCno(int Cno) {
        this.Cno = Cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    public int getCnun() {
        return Cnun;
    }

    public void setCnun(int Cnun) {
        this.Cnun = Cnun;
    }
}
