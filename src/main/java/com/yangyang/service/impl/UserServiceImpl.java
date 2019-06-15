package com.yangyang.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yangyang.dao.UserDao;
import com.yangyang.dto.UserExecution;
import com.yangyang.entity.User;
import com.yangyang.entity.UserFollow;
import com.yangyang.model.LoginModel;
import com.yangyang.model.response.UserCard;
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

	@Override
	public User login(LoginModel loginModel) {
		return userDao.login(loginModel);
	}

    @Override
    public int bind(String userToken, String pushId, Integer userId) {
        return userDao.bind(userToken,pushId,userId);
    }



	@Override
	public User findById(int userId) {
		return userDao.findById(userId);
	}

	@Override
	public User findByToken(String userToken) {
		return userDao.findByToken(userToken);
	}

    @Override
    public List<User> search(String userName) {
        return userDao.search(userName);
    }

    @Override
    public int follow(UserFollow follow) {
        return userDao.follow(follow);
    }

    @Override
    public UserFollow isFollow(Integer originId, Integer targetId) {
        return userDao.isFollow(originId,targetId);
    }

    @Override
    public List<UserFollow> getFriend(int originId) {
        return userDao.getFriend(originId);
    }


}
