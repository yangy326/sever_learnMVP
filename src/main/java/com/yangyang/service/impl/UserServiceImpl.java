package com.yangyang.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yangyang.dao.UserDao;
import com.yangyang.dto.UserExecution;
import com.yangyang.entity.User;
import com.yangyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;




	@Override
	@Transactional
	public UserExecution addUser(User  user) {

		try {

		}catch (Exception e){
			throw new RuntimeException("addUser error:" + e.getMessage());
		}
		return null;
	}

	@Override
	public int createUser(User user) {
		return userDao.createUser(user);
	}



	@Override
	public User findByAccount(String userAccount) {
		return userDao.findByAccount(userAccount);
	}
}
