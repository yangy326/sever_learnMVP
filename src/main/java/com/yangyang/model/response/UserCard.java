package com.yangyang.model.response;

import com.yangyang.entity.User;

public class UserCard {
    private Integer userId;
    private String userName;
    private String userAccount;
    private int userSex;


    private int isFollow;

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public int getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(int isFollow) {
        this.isFollow = isFollow;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }


    public void setFollow(int follow) {
        isFollow = follow;
    }
    public UserCard (User user , int Follow){
        this(user.getUserId(),user.getUserName(),user.getUserAccount(),user.getUserSex(),Follow);


    }

    public UserCard(Integer userId, String userName, String userAccount, int userSex, int isFollow) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userSex = userSex;
        this.isFollow = isFollow;
    }
}
