package com.demo.ems_thymeleaf.inceptor;

import com.mysql.cj.Session;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("user")){

                    return true;
                }
            }
        }
        response.sendRedirect(request.getContextPath()+"/");
        return false;
    }
}
