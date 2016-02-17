package com.pblog.web.controller.article;

import com.pblog.service.article.ArticleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource(name = "articleInfoService")
    private ArticleInfoService articleInfoService;

    @RequestMapping(value = "/{slug}")
    public String articleBySlug(@PathVariable Long slug, HttpServletRequest request, Model model){
        

        return "";
    }
}
