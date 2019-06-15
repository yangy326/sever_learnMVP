package com.yangyang.web.superadmin;

import java.net.URLDecoder;
import java.util.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

import com.yangyang.entity.User;
import com.yangyang.entity.UserFollow;
import com.yangyang.model.LoginModel;
import com.yangyang.model.response.UserCard;
import com.yangyang.service.UserService;
import com.yangyang.util.TextUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService UserService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> register(@RequestBody User user ) {

		Map<String, Object> modelMap = new HashMap<String, Object>();

//		String newToken = UUID.randomUUID().toString();
//		newToken = TextUtil.getMD5(newToken);


		User user1 = UserService.findByAccount(user.getUserAccount());
		if (user1 != null){
			modelMap.put("success",false);
			modelMap.put("code",403);
			modelMap.put("data",null);






		}

		else {
			//user.setUserToken(newToken);
			user.setCreateTime(new Date());
			int num = UserService.createUser(user);
			if (num > 0){
				modelMap.put("success",true);
				modelMap.put("code",400);
				modelMap.put("data",null);




			}

		}
		return modelMap;


	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> login(@RequestBody LoginModel loginModel ) {

		Map<String, Object> modelMap = new HashMap<String, Object>();

//		String newToken = UUID.randomUUID().toString();
//		newToken = TextUtil.getMD5(newToken);


		User user1 = UserService.login(loginModel);
		if (user1 != null){
			String newToken = UUID.randomUUID().toString();
		    newToken = TextUtil.getMD5(newToken);
		    int num = UserService.bind(newToken,loginModel.getPushId(),user1.getUserId());
		    if (num==1){
		    	User user = UserService.findByToken(newToken);
				modelMap.put("success",true);
				modelMap.put("code",400);
				modelMap.put("data",user);
			}
		    else {
				modelMap.put("success",false);
				modelMap.put("code",401);
				modelMap.put("data",null);
			}







		}

		else {
			modelMap.put("success",false);
			modelMap.put("code",401);
			modelMap.put("data",null);

		}
		return modelMap;


	}


	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> search(@Param("userName") String userName ,@RequestHeader("userToken") String userToken) {

		Map<String, Object> modelMap = new HashMap<String, Object>();

//		String newToken = UUID.randomUUID().toString();
//		newToken = TextUtil.getMD5(newToken);
		User user = UserService.findByToken(userToken);
		if (user != null){
			List <User> user1 = UserService.search(userName);
			if (user1 != null ){
				modelMap.put("success",true);
				modelMap.put("code",400);
				modelMap.put("data",user1);
			}
			else {
				modelMap.put("success",false);
				modelMap.put("code",404);
				modelMap.put("data",null);
			}
		}
		else {
			modelMap.put("success",false);
			modelMap.put("code",403);
			modelMap.put("data",null);
		}


		return modelMap;


	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> search(@Param("userId") int userId ,@RequestHeader("userToken") String userToken) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		UserCard card;

//		String newToken = UUID.randomUUID().toString();
//		newToken = TextUtil.getMD5(newToken);
		User user = UserService.findByToken(userToken);
//		if (user.getUserId() == userId){
//			card = new UserCard(user,2);
//			modelMap.put("success",true);
//			modelMap.put("code",400);
//			modelMap.put("data",card);
//		}
		if (user != null){
			User user1 = UserService.findById(userId);
			if (user1 != null ){
				Integer originId = user.getUserId();
				Integer targetId = user1.getUserId();
				UserFollow follow = UserService.isFollow(originId,targetId);

				if (follow != null){
					card = new UserCard(user1,2);
					modelMap.put("success",true);
					modelMap.put("code",400);
					modelMap.put("data",card);
				}
				else {
					card = new UserCard(user1,0);
					modelMap.put("success",true);
					modelMap.put("code",400);
					modelMap.put("data",card);
				}

			}
			else {
				modelMap.put("success",false);
				modelMap.put("code",404);
				modelMap.put("data",null);
			}
		}
		else {
			modelMap.put("success",false);
			modelMap.put("code",403);
			modelMap.put("data",null);
		}


		return modelMap;


	}
	@RequestMapping(value = "/follow", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> follow(@Param("originId") Integer originId ,
									   @Param("targetId") Integer targetId ,
									   @RequestHeader("userToken") String userToken) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		Date date = new Date();
		UserFollow follow1 = new UserFollow();
		follow1.setOriginId(originId);
		follow1.setTargetId(targetId);
		follow1.setCreateTime(date);

		int temp ;
		temp = originId;
		originId = targetId;
		targetId = temp;

		UserFollow follow2 = new UserFollow();
		follow2.setOriginId(originId);
		follow2.setTargetId(targetId);
		follow2.setCreateTime(date);


//		String newToken = UUID.randomUUID().toString();
//		newToken = TextUtil.getMD5(newToken);
		User user = UserService.findByToken(userToken);
		if (user != null){
			int i = UserService.follow(follow1);
			int j = UserService.follow(follow2);
			if (i > 0 && j > 0){
				User user1 = UserService.findById(targetId);
				if (user1 != null ){
					modelMap.put("success",true);
					modelMap.put("code",400);
					modelMap.put("data",user1);
				}
				else {
					modelMap.put("success",false);
					modelMap.put("code",404);
					modelMap.put("data",null);
				}
			}
			else {
				modelMap.put("success",false);
				modelMap.put("code",404);
				modelMap.put("data",null);
			}

		}
		else {
			modelMap.put("success",false);
			modelMap.put("code",403);
			modelMap.put("data",null);
		}


		return modelMap;


	}



}
