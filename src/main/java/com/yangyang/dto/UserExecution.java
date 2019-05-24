package com.yangyang.dto;

import com.yangyang.entity.User;
import com.yangyang.entity.enums.UserStateEnum;

import java.util.List;

public class UserExecution {

    private int state;

    private String info;

    private User user;

    private List<User> list;

    public UserExecution(UserStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.info = stateEnum.getInfo();
    }

    // 成功的构造器
    public UserExecution(UserStateEnum stateEnum, User user) {
        this.state = stateEnum.getState();
        this.info = stateEnum.getInfo();
        this.user= user;
    }

    // 成功的构造器
    public UserExecution(UserStateEnum stateEnum, List<User> userList) {
        this.state = stateEnum.getState();
        this.info = stateEnum.getInfo();
        this.list = userList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
