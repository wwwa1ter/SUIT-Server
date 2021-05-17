package com.pose.interceptor;

import com.pose.exception.user.LoginFailException;
import com.pose.pojo.User;
import com.pose.service.user.UserService;
import com.pose.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class SessionInterceptor implements HandlerInterceptor {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean identify = false;
        HttpSession session = request.getSession();
        String requestToken = request.getHeader(Constants.TOKEN);
        String sessionToken = (String) session.getAttribute(Constants.TOKEN);

        if (requestToken != null && sessionToken == null){
            User user = userService.queryToken(requestToken);
            if (user != null) {
                session.setAttribute(Constants.TOKEN, requestToken);
                session.setAttribute(Constants.USER_SESSION, user);
                identify = true;
            }
        }

        if (!identify && requestToken != null && requestToken.equals(sessionToken)){
            if (session.getAttribute(Constants.USER_SESSION) == null){
                session.setAttribute(Constants.USER_SESSION, userService.queryToken(sessionToken));
            }
            identify = true;
        }

        if (identify){
            return true;
        }else {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
