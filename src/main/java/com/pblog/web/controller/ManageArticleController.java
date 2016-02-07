package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "manage/article")
public class ManageArticleController {

    @RequestMapping("/list")
    public String index(Model model){
        return "manage/article/article_list";
    }

    @RequestMapping("/add")
    public String add(Model model){

        return "manage/article/article_add";
    }

}
