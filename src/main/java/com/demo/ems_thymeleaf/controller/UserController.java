package com.demo.ems_thymeleaf.controller;

import com.demo.ems_thymeleaf.entity.User;
import com.demo.ems_thymeleaf.service.UserService;
import com.demo.ems_thymeleaf.utils.CaptcahCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //生成验证码并设置session
    @RequestMapping("code")
    public void getImage(HttpSession session, HttpServletResponse response){
        String code=CaptcahCode.drawImage(response);
        session.setAttribute("newCode",code);
    }

    //登录方法
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, HttpServletResponse response){
        User login=userService.login(username, password);
        if(login!=null){
            session.setAttribute("user",login);
            response.addCookie(new Cookie("user",username));
            return "redirect:/empList2";
        }else {
            return "redirect:/";
        }
    }

    //注册方法
    @PostMapping("/register")
    public String register(User user, String code, HttpSession session){
        String sessionCode=(String)session.getAttribute("newCode");
        if(sessionCode.equalsIgnoreCase(code)){
            userService.register(user);
            return "redirect:/";
        }else {
            return "redirect:/regist";
        }

    }

}
