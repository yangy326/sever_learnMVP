package com.yangyang.service;

import com.yangyang.BaseTest;
import com.yangyang.dao.UserDao;
import com.yangyang.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testBQueryArea(){
//        List<User> areaList = userService.getUserList();
//        assertEquals("yangyang", areaList.get(0).getUserName());
    }

}
