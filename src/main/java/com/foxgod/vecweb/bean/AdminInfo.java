package com.foxgod.vecweb.bean;

public class AdminInfo {

    private String name="";
    private String password="";
    private String jurisdiction="";
    private String remarks ="";

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
