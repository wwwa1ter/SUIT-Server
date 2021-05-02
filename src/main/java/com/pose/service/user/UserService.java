package com.pose.service.user;

import com.pose.pojo.User;

import java.util.Map;

public interface UserService {
    //注册
    boolean register(User user);

    //登录
    Map login(User user);

    boolean logout(String token);

    //添加用户
    boolean addUser(User user);

    //查找用户
    User queryUserById(String id);

    //删除用户
    boolean deleteUserById(String id);

    //修改用户
    boolean updateUser(User user);

    User queryToken(String token);

}
