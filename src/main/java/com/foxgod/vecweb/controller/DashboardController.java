package com.foxgod.vecweb.controller;

import com.foxgod.vecweb.bean.UserInfo;
import com.foxgod.vecweb.bean.UserVisit;
import com.foxgod.vecweb.mapper.DashboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    DashboardMapper dashboardMapper;

    @GetMapping("/main")
    public String main(Model model) {

        List<UserVisit> todayvisitnumber_list=dashboardMapper.getTodayVisitNumber(
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        List<UserInfo> newUser_list=dashboardMapper.getNewUser(
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        List<UserInfo> userNumber_list=dashboardMapper.getUserNumber();
        List<UserVisit> weekVisitNumber_list=dashboardMapper.getWeekVisitNumber();

        model.addAttribute("todayVisitNumber",todayvisitnumber_list.size());
        model.addAttribute("newUsernumber",newUser_list.size());
        model.addAttribute("userNumber",userNumber_list.size());
        model.addAttribute("weekVisitNumber",weekVisitNumber_list.size());
        return "page/fistpage";
    }
}
