package com.foxgod.vecweb.controller;

import com.foxgod.common.encryption.MD5Utils;
import com.foxgod.vecweb.bean.AdminInfo;
import com.foxgod.vecweb.bean.AdminJurisdiction;
import com.foxgod.vecweb.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    /**
     * 角色管理页面
     */
    @GetMapping("/admin")
    public String getadmin(Model model) {
        //获取管理员信息
        List<AdminInfo> admins = adminMapper.getAllAdmins();
        model.addAttribute("admins", admins);
        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        model.addAttribute("adminJurisdictions", adminJurisdictions);
        return "page/admin/info";
    }

    /**
     * 添加角色页面
     */
    @GetMapping("/admin/add")
    public String getaddadmin(Model model) {
        //获取权限
        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        model.addAttribute("adminJurisdictions", adminJurisdictions);
        return "page/admin/add";
    }

    /**
     * 添加角色
     */
    @PostMapping("/admin")
    public String addadmin(AdminInfo adminInfo, Model model, RedirectAttributes attributes) {

        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        for (int i = 0; i < adminJurisdictions.size(); i++) {
            if (adminJurisdictions.get(i).getName().equals(adminInfo.getJurisdiction())) {
                adminInfo.setJurisdiction(adminJurisdictions.get(i).getNum().toString());
                break;
            }
        }
        MD5Utils md5 = new MD5Utils("MD5", adminInfo.getPassword(), adminInfo.getName(), 1024);
        adminInfo.setPassword(md5.result());
        adminMapper.addadmin(adminInfo);
        return "redirect:/admin";
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/admin")
    public String deladmin(@RequestParam("name") String name) {
        adminMapper.deladmin(name);
        return "redirect:/admin";
    }

    /**
     * 修改角色
     */
    @PutMapping("/admin")
    public String putadmin(AdminInfo adminInfo) {

        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        for (AdminJurisdiction adminJurisdiction : adminJurisdictions) {
            if (adminJurisdiction.getName().equals(adminInfo.getJurisdiction())) {
                adminInfo.setJurisdiction(adminJurisdiction.getNum().toString());
                break;
            }
        }
        adminMapper.update(adminInfo);
        return "redirect:/admin";
    }

    /**
     * 校验用户名
     */
    @ResponseBody
    @PostMapping("/checkLoginNameUnique")
    public String checkLoginNameUnique(@RequestParam("name") String loginName) {
        // 校验用户名  1存在  0不存
        if (adminMapper.isadminname(loginName) > 0) {
            return "1";
        }
        return "0";
    }
}
