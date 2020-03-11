package com.foxgod.vecweb.controller;

import com.foxgod.vecweb.bean.AdminInfo;
import com.foxgod.vecweb.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        AdminInfo adminInfo = loginMapper.userlogin(username);
        if (adminInfo == null) {
            map.put("msg", "用户不存在");
            return "login";
        }
        System.out.println("返回值：" + adminInfo.getPassword());
        if (!password.equals(adminInfo.getPassword())) {
            map.put("msg", "密码错误");
            return "login";
        }
        session.setAttribute("username",username);
        return "redirect:/main";
    }
}
