package com.demo.ems_thymeleaf.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("user");
        if(user!=null){
            return true;
        }else {
            request.setAttribute("msg","未登录");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }

    }
}
