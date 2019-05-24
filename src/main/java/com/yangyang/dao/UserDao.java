package com.yangyang.dao;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.yangyang.entity.User;

import java.util.List;

public interface UserDao {



    List<User> queryUser();

    /**
     *
     * @param user
     * @return 返回1代表成功 返回-1代表失败
     */
    int createUser(User user);

    int updateUser(User user);

    User findByAccount(String Account);
}
