package com.yangyang.service;


import com.yangyang.dto.UserExecution;
import com.yangyang.entity.User;

import java.util.List;

public interface UserService {

	UserExecution addUser(User user);

	int createUser(User user);

	User findByAccount(String useccount);



}
