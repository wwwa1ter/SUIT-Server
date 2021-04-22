package com.pose.dao;

import com.pose.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    //添加用户
    int addUser(User user);

    //查找用户
    User queryUserById(String id);

    //删除用户
    int deleteUserById(String id);

    //修改用户
    int updateUser(User user);

    int addToken(@Param("token") String token, @Param("userId") String userId);

    User queryToken(String token);

    int deleteToken(String token);
}
