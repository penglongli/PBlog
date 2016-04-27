package com.pblog.web.controller;

import com.google.common.collect.Maps;
import com.pblog.service.article.ArticleInfoService;
import com.pblog.service.article.ArticleInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource(name = "articleInfoService")
    private ArticleInfoService articleInfoService;

    /*@RequestMapping(value = "/{slug}")
    public String articleBySlug(@PathVariable Long slug, HttpServletRequest request, Model model){
        String ipAddress = (String) request.getAttribute("realIp");

        ArticleInfoVO articleInfoVO = articleInfoService.findArticleBySlug(slug, request);

        model.addAttribute("detail", true);
        model.addAttribute("firstArticle", articleInfoVO);
        return "web/index/index";
    }*/

    @RequestMapping(value = "/slug/layout", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        return "web/article/article";
    }

    @RequestMapping(value ="/{slug}", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> articleBySlug(@PathVariable Long slug, HttpServletRequest request) {
        ArticleInfoVO articleInfoVO = articleInfoService.findArticleBySlug(slug, request);

        Map<String, Object> map = Maps.newHashMap();
        map.put("articleVO", articleInfoVO);
        return map;
    }
}
