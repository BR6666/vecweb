package com.foxgod.vecweb.controller;

import com.foxgod.vecweb.bean.LoginUser;
import com.foxgod.vecweb.mapper.LoginMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginMapper loginMapper;

    @GetMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        if (request.getParameter("kickout") == null) {
            return "login";
        }
        map.put("msg", "您已在别处登录");
        return "login";
    }


    @PostMapping("/login")
    public String userlogin(LoginUser loginUser, Map<String, Object> map) {
        System.out.println("用户名：" + loginUser.getUserName() + " 密码：" + loginUser.getPassWord() + " 记住密码：" + loginUser.getRememberMe());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getUserName(), loginUser.getPassWord(), loginUser.getRememberMe());
        try {
            subject.login(token);
        } catch (UnknownAccountException ue) {
            System.out.println(loginUser.getUserName() + "------登录失败------" + ue.getMessage());
            map.put("msg", "用户不存在");
            return "login";
        } catch (AuthenticationException ae) {
            System.out.println(loginUser.getUserName() + "------登录失败------" + ae.getMessage());
            map.put("msg", "用户名或密码错误");
            return "login";
        }
        return "redirect:/main";
    }
}
