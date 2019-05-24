package com.yangyang.entity.enums;

public enum UserStateEnum {

    SUCCESS(0, "操作成功");

    private int state;

    private String info;

    UserStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }
    public static UserStateEnum stateOf(int index) {
        for (UserStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
