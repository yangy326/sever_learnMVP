package com.yangyang.web.useradmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yangyang.entity.User;
import com.yangyang.service.UserService;
import com.yangyang.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@RequestMapping("/shop")
public class UserManagementController {
	@Autowired
	private UserService userService;




	@RequestMapping(value = "/registershop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success",true);
		modelMap.put("method",request.getMethod());
		return modelMap;

//		Map<String, Object> modelMap = new HashMap<String, Object>();
//
//		ObjectMapper mapper = new ObjectMapper();
//		User user = null;
//		String shopStr = HttpServletRequestUtil.getString(request, "userStr");
//
//		try {
//			user = mapper.readValue(shopStr, User.class);
//		} catch (Exception e) {
//			modelMap.put("success", false);
//			modelMap.put("errMsg", e.toString());
//			return modelMap;
//		}
//		if (user != null ) {
//			try {
//				PersonInfo user = (PersonInfo) request.getSession()
//						.getAttribute("user");
//				shop.setOwnerId(user.getUserId());
//				ShopExecution se = shopService.addShop(shop, shopImg);
//				if (se.getState() == ShopStateEnum.CHECK.getState()) {
//					modelMap.put("success", true);
//					// 若shop创建成功，则加入session中，作为权限使用
//					@SuppressWarnings("unchecked")
//					List<Shop> shopList = (List<Shop>) request.getSession()
//							.getAttribute("shopList");
//					if (shopList != null && shopList.size() > 0) {
//						shopList.add(se.getShop());
//						request.getSession().setAttribute("shopList", shopList);
//					} else {
//						shopList = new ArrayList<Shop>();
//						shopList.add(se.getShop());
//						request.getSession().setAttribute("shopList", shopList);
//					}
//				} else {
//					modelMap.put("success", false);
//					modelMap.put("errMsg", se.getStateInfo());
//				}
//			} catch (RuntimeException e) {
//				modelMap.put("success", false);
//				modelMap.put("errMsg", e.toString());
//				return modelMap;
//			}
//
//		} else {
//			modelMap.put("success", false);
//			modelMap.put("errMsg", "请输入店铺信息");
//		}
//		return modelMap;
	}

}
