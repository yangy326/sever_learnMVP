package com.yangyang.web.superadmin;

import com.yangyang.entity.User;
import com.yangyang.entity.UserFollow;
import com.yangyang.util.PushDispatcher;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private com.yangyang.service.UserService UserService;

    @RequestMapping(value = "/pushperson", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> search( @RequestHeader("userToken") String userToken) throws IOException {

        Map<String, Object> modelMap = new HashMap<String, Object>();

//		String newToken = UUID.randomUUID().toString();
//		newToken = TextUtil.getMD5(newToken);
        User user = UserService.findByToken(userToken);
        List<User> list = new ArrayList<>();
        if (user != null){
//            PushDispatcher dispatcher = new PushDispatcher();
//            dispatcher.add("650390bfc1d12c14fd7471e29e04bfb8","hello");
//            dispatcher.submit();

        }

        else {

        }


        return modelMap;


    }
}
