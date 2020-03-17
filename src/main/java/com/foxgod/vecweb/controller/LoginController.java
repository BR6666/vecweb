package com.foxgod.vecweb.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginMapper loginMapper;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String userlogin(@RequestParam("username") String username, @RequestParam("password") String password,
                            Map<String, Object> map, HttpSession session) {
        System.out.println("用户名：" + username + "密码：" + password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException ue) {
            System.out.println(username + "------登录失败------" + ue.getMessage());
            map.put("msg", "用户不存在");
            return "login";
        } catch (AuthenticationException ae) {
            System.out.println(username + "------登录失败------" + ae.getMessage());
            map.put("msg", "用户名或密码错误");
            return "login";
        }
        return "redirect:/main";
    }

//    @PostMapping("/loginasd")
//    public String loginasd(@RequestParam("username") String username, @RequestParam("password") String password) {
//        System.out.println(username + "+++++" + password);
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
//            subject.login(token);
//        } catch (AuthenticationException ae) {
//            ae.printStackTrace();
//            System.out.println(username + "------登录失败------" + ae.getMessage());
//
//        }
//        return "index";
//    }
}
