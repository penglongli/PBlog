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

    //------------------移动端-------------------------

    @RequestMapping(value = "/{slug}/detail", method = RequestMethod.GET)
    public String index(@PathVariable Long slug, HttpServletRequest request, Model model) {
        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if (!mobile) {
            return "redirect:/#/article/" + slug;
        }

        String ipAddress = (String) request.getAttribute("realIp");
        ArticleInfoVO articleInfoVO = articleInfoService.findArticleBySlug(slug, ipAddress);
        model.addAttribute("articleInfo", articleInfoVO);
        return "web/article/article_mobile";
    }

    //--------------------PC端——-----------------------

    @RequestMapping(value = "/slug/layout", method = RequestMethod.GET)
    public String layout(HttpServletRequest request, Model model) {

        return "web/article/layout";
    }

    @RequestMapping(value ="/{slug}", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> articleJson(@PathVariable Long slug, HttpServletRequest request) {
        String ipAddress = (String) request.getAttribute("realIp");
        ArticleInfoVO articleInfoVO = articleInfoService.findArticleBySlug(slug, ipAddress);

        Map<String, Object> map = Maps.newHashMap();
        map.put("articleVO", articleInfoVO);
        return map;
    }
}
