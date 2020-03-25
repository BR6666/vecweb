package com.foxgod.vecweb.controller;

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

    //获取角色管理页面
    @GetMapping("/admin")
    public String getadmin(Model model) {
        //获取管理员信息
        List<AdminInfo> admins = adminMapper.getAllAdmins();
        model.addAttribute("admins", admins);
        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        model.addAttribute("adminJurisdictions", adminJurisdictions);
        return "page/admininfo";
    }

    //添加角色
    @GetMapping("/admin/add")
    public String getaddadmin(Model model) {
        //获取权限
        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        model.addAttribute("adminJurisdictions", adminJurisdictions);
        return "page/addadmin";
    }

    // 添加角色
    @PostMapping("/admin")
    public String addadmin(AdminInfo adminInfo, Model model, RedirectAttributes attributes) {

        AdminInfo isuser = adminMapper.isadminname(adminInfo.getName());
        if (isuser != null) {
            attributes.addFlashAttribute("msg", "用户名已存在");
            return "redirect:/admin/add";
        }
        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        for (int i = 0; i < adminJurisdictions.size(); i++) {
            if (adminJurisdictions.get(i).getName().equals(adminInfo.getJurisdiction())) {
                adminInfo.setJurisdiction(adminJurisdictions.get(i).getNum().toString());
                break;
            }
        }
        adminMapper.addadmin(adminInfo);
        return "redirect:/admin";
    }

    //删除角色
    @DeleteMapping("/admin")
    public String deladmin(@RequestParam("name") String name) {
        adminMapper.deladmin(name);
        return "redirect:/admin";
    }

    // 修改角色
    @PutMapping("/admin")
    public String putadmin(AdminInfo adminInfo) {

        List<AdminJurisdiction> adminJurisdictions = adminMapper.selectadminjurisdiction();
        for (AdminJurisdiction adminJurisdiction : adminJurisdictions) {
            if (adminJurisdiction.getName().equals(adminInfo.getJurisdiction())){
                adminInfo.setJurisdiction(adminJurisdiction.getNum().toString());
                break;
            }
        }
        adminMapper.update(adminInfo);
        return "redirect:/admin";
    }

}
