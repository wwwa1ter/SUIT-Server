package com.pose.controller.user;

import com.pose.pojo.User;
import com.pose.service.user.UserService;
import com.pose.utils.Constants;
import com.pose.utils.ServerResponse;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ServerResponse login(User user, HttpSession httpSession){
        Map<String, Object> map = userService.login(user);
        if (map.containsKey(Constants.USER_SESSION)){
            User userQuery = (User) map.get(Constants.USER_SESSION);
            String token = (String) map.get(Constants.TOKEN);
            httpSession.setAttribute(Constants.USER_SESSION, userQuery);
            httpSession.setAttribute(Constants.TOKEN, token);
            Map<String, String> responseMap = new HashMap();
            responseMap.put("token", token);
            responseMap.put("name", userQuery.getName());
            return new ServerResponse(responseMap);
        }
        return null;
    }

    @DeleteMapping("/logout")
    public void logout(HttpSession httpSession){
        String token = (String)httpSession.getAttribute(Constants.TOKEN);
        userService.logout(token);
        httpSession.invalidate();
    }

    @PostMapping("/register")
    public ResponseEntity register(User user){
        if (userService.register(user)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
