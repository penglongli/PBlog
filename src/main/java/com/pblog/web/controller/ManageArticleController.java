package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageArticleController {

    @RequestMapping("/")
    public String index(Model model){
        return "manage/article/article_list";
    }

    @RequestMapping("/add")
    public String add(Model model){

        return "manage/article/article_add";
    }
}
