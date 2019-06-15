package com.yangyang.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userAccount;

    private String userName;

    private String userPassword;

    private String userImage;

    private String userToken;

    private int userSex;

    private Date createTime;

    private String pushId;

    public String getPusgId() {
        return pushId;
    }

    public void setPusgId(String pusgId) {
        this.pushId = pusgId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getUserToken() {
        return userToken;
    }

    public int getUserSex() {
        return userSex;
    }

    public Date getCreateTime() {
        return createTime;
    }
}


