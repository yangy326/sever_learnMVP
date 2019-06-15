package com.yangyang.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.yangyang.BaseTest;
import com.yangyang.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest extends BaseTest {
	@Autowired
	private  UserDao userDao;

	@Test
	public void testBQueryArea() throws Exception {
		User user = new User();
		user.setUserId(4);
		user.setUserName("xiongyuanxiu");

		user.setUserToken("234");
		user.setUserImage("http://www.baidu.com");

		user.setCreateTime(new Date());
		//
	}


}
