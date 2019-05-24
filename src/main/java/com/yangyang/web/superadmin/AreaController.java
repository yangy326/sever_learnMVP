package com.yangyang.web.superadmin;

import java.net.URLDecoder;
import java.util.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

import com.yangyang.entity.User;
import com.yangyang.service.UserService;
import com.yangyang.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/superadmin")
public class AreaController {
	@Autowired
	private UserService UserService;

	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> listUers(@RequestBody User user) {

		Map<String, Object> modelMap = new HashMap<String, Object>();

		String newToken = UUID.randomUUID().toString();
		newToken = TextUtil.getMD5(newToken);


		User user1 = UserService.findByAccount(user.getUserAccount());
		if (user1 != null){
			modelMap.put("success",false);
			modelMap.put("message","该用户也存在");
			modelMap.put("accessToken",null);




		}

		else {
			user.setUserToken(newToken);
			user.setCreateTime(new Date());
			int num = UserService.createUser(user);
			if (num > 0){
				modelMap.put("success",true);
				modelMap.put("message","注册成功");
				modelMap.put("accessToken",newToken);

			}

		}
		return modelMap;


	}



}
