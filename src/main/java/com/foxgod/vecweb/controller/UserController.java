package com.foxgod.vecweb.controller;

import com.foxgod.vecweb.bean.UserInfo;
import com.foxgod.vecweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public String user(Model model){

        List<UserInfo> users = userMapper.getAllUsers();
        model.addAttribute("users", users);

        return "page/userinfo";
    }
}
