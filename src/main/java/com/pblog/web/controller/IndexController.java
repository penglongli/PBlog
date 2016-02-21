package com.pblog.web.controller;

import com.pblog.core.orm.PageRequest;
import com.pblog.service.article.ArticleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource(name = "articleInfoService")
    private ArticleInfoService articleInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        PageRequest pageRequest = new PageRequest(1, 10);

        articleInfoService.findTopTenArticlesByCreateTime();
        return "web/index/index";
    }

    @RequestMapping(value = "/article/list/{page}", method = RequestMethod.GET)
    public String page(@PathVariable Integer page, Model model){

        return "";
    }

}
