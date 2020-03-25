package com.foxgod.vecweb.bean;

/**
 * @Description
 * @Author FoxGod
 * @Date 2020/03/25 15:25
 */
public class UserVisit {
    String ip;
    String visitTime;
    String remarks;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
