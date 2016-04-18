package com.pblog.web.controller;

import com.pblog.service.article.ArticleInfoService;
import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.log.ArticleReadLogService;
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

    @Resource(name = "articleReadLogService")
    private ArticleReadLogService articleReadLogService;

    @RequestMapping(value = "/{slug}")
    public String articleBySlug(@PathVariable Long slug, HttpServletRequest request, Model model){
        String ipAddress = (String) request.getAttribute("realIp");

        ArticleInfoVO articleInfoVO = articleInfoService.findArticleBySlug(slug, request);
        articleReadLogService.addByRead(slug, ipAddress);

        model.addAttribute("detail", true);
        model.addAttribute("firstArticle", articleInfoVO);
        return "web/index/index";
    }
}
