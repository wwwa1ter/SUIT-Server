package com.pose.service.user;

import com.pose.dao.UserDao;
import com.pose.exception.user.LoginFailException;
import com.pose.exception.user.RegisterFailException;
import com.pose.pojo.User;
import com.pose.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService{


    private UserDao userDao;

    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean register(User user) {
        if (queryUserById(user.getId()) != null){
            throw new RegisterFailException("账号已存在");
        }
        return this.addUser(user);
    }

    @Override
    public Map<String, Object> login(User user) {
        User userQuery = userDao.queryUserById(user.getId());
        if (userQuery != null){
            if (userQuery.getPassword().equals(user.getPassword())){
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                Map<String, Object> responseMap = new HashMap();
                responseMap.put(Constants.TOKEN, token);
                responseMap.put(Constants.USER_SESSION, userQuery);
                userDao.addToken(token, userQuery.getId());
                return responseMap;
            }else {
                throw new LoginFailException("密码错误");
            }
        }else {
            throw new LoginFailException("账号不存在");
        }
    }

    @Override
    public boolean logout(String token) {
        return userDao.deleteToken(token) > 0;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) > 0;
    }

    @Override
    public User queryUserById(String id) {
        return userDao.queryUserById(id);
    }

    @Override
    public boolean deleteUserById(String id) {
        return userDao.deleteUserById(id) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }

    @Override
    public User queryToken(String token) {
        return userDao.queryToken(token);
    }
}
