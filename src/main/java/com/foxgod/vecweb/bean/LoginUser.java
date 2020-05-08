package com.foxgod.vecweb.bean;

/**
 * @Description
 * @Author FoxGod
 * @Date 2020/04/06 13:33
 */
public class LoginUser {

    public String userName;
    public String passWord;
    public Boolean rememberMe=false;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
