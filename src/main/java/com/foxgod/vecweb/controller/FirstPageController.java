package com.foxgod.vecweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstPageController {

    @GetMapping("/main")
    public String main() {
        return "page/fistpage";
    }
}
