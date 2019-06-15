package com.yangyang.web.superadmin;

import com.yangyang.entity.User;
import com.yangyang.entity.UserFollow;
import com.yangyang.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private com.yangyang.service.UserService UserService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> search(@Param("originId") Integer originId , @RequestHeader("userToken") String userToken) {

        Map<String, Object> modelMap = new HashMap<String, Object>();

//		String newToken = UUID.randomUUID().toString();
//		newToken = TextUtil.getMD5(newToken);
        User user = UserService.findByToken(userToken);
        List<User> list = new ArrayList<>();
        if (user != null){
            List<UserFollow> user1 = UserService.getFriend(originId);
            if (user1 != null ){
                for (int i = 0 ; i < user1.size(); i ++){
                    User user2 = UserService.findById(user1.get(i).getTargetId());
                    list.add(user2);
                }

                modelMap.put("success",true);
                modelMap.put("code",400);
                modelMap.put("data",list);
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
