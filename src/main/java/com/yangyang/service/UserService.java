package com.yangyang.service;


import com.yangyang.dto.UserExecution;
import com.yangyang.entity.User;
import com.yangyang.entity.UserFollow;
import com.yangyang.model.LoginModel;
import com.yangyang.model.response.UserCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

	UserExecution addUser(User user);

	int createUser(User user);

	User findByAccount(String useccount);

	User login(LoginModel loginModel);

	int bind(String userToken,String pushId,Integer userId);

	User findById(int userId);

	User findByToken(String userToken);

	List<User> search(String name );

	int follow(UserFollow follow);

	UserFollow isFollow(Integer originId,Integer targetId);

	List<UserFollow> getFriend(int originId );








}
