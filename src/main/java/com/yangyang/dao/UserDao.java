package com.yangyang.dao;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.yangyang.entity.User;
import com.yangyang.entity.UserFollow;
import com.yangyang.model.LoginModel;
import com.yangyang.model.response.UserCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {



    List<User> queryUser();

    /**
     *
     * @param user
     * @return 返回1代表成功 返回-1代表失败
     */
    int createUser(User user);

    List<User> search(String userName );

    UserFollow isFollow(@Param("originId")Integer originId,@Param("targetId")Integer targetId);

    List<UserFollow> getFriend(int originId );

    List<User> getRealFriend(int userId );

    int bind(@Param("userToken")String userToken,@Param("pushId")String pushId,@Param("userId")Integer userId);

    User findByAccount(String Account);

    User login(LoginModel loginModel);

    User findById(int userId);

    int follow(UserFollow follow);

    User findByToken(String userToken);
}
