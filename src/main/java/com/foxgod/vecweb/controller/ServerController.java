package com.foxgod.vecweb.controller;

import com.foxgod.monitor.Server;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author FoxGod
 * @Date 2020/03/28 16:15
 */
@Controller
public class ServerController {

    @GetMapping("/server")
    public String server(Model model) throws Exception {

        Server server = new Server();
        server.info();
        model.addAttribute("server", server);
        return "page/server";
    }
}
