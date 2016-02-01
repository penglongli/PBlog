package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "manageIndexController")
public class ManageIndexController {

    @RequestMapping("/")
    public String index(Model model){
        System.out.println("测试");
        return "manage/index/index";
    }
}
