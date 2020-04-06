package com.foxgod.vecweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author FoxGod
 * @Date 2020/03/31 15:54
 */
@Controller
public class DruidController {

    @GetMapping("/druid")
    public String druid(){

        return "/page/druid";
    }
}
