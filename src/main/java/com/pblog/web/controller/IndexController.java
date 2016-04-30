package com.pblog.web.controller;

import com.google.common.collect.Maps;
import com.pblog.core.orm.PageRequest;
import com.pblog.core.orm.Pagination;
import com.pblog.service.article.ArticleInfoService;
import com.pblog.service.article.ArticleInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController {

    @Resource(name = "articleInfoService")
    private ArticleInfoService articleInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRootPage(HttpServletRequest request, Model model) {
        Boolean mobile = (Boolean) request.getAttribute("mobile");

        if(!mobile) {
            return "web/home";
        }else {
            return "";
        }
    }

    @RequestMapping(value = "/index/layout", method = RequestMethod.GET)
    public String getIndexPage(HttpServletRequest request, Model model){

        return "web/index/index";
    }

    @RequestMapping(value ="/topTenArticle", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, Model model){
        Integer page = 1;
        PageRequest pageRequest = new PageRequest(page, 10);

        Pagination<ArticleInfoVO> pagination = articleInfoService.page(pageRequest);
        ArticleInfoVO firstArticleInfoVO = null;
        if(pagination.getItems().size() > 0){
            firstArticleInfoVO = pagination.getItems().get(0);
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("pagination", pagination);
        map.put("firstArticle", firstArticleInfoVO);
        map.put("detail", false);

        return map;
    }


    /*@RequestMapping(value = {"/", "/article/list"}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "p", required = false)Integer page, HttpServletRequest request, Model model){
        page = (null == page) ? 1 : page;
        PageRequest pageRequest = new PageRequest(page, 10);

        Pagination<ArticleInfoVO> pagination = articleInfoService.page(pageRequest);
        ArticleInfoVO firstArticleInfoVO = null;
        if(pagination.getItems().size() > 0){
            firstArticleInfoVO = pagination.getItems().get(0);
        }

        model.addAttribute("pagination", pagination);
        model.addAttribute("firstArticle", firstArticleInfoVO);
        model.addAttribute("detail", false);

        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if(mobile){
            return "web/index/index_mobile";
        }else{
            return "web/home";
        }
    }*/

   /* @RequestMapping(value ="index", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> index2(HttpServletRequest request, Model model){
        Integer page = 1;
        PageRequest pageRequest = new PageRequest(page, 10);

        Pagination<ArticleInfoVO> pagination = articleInfoService.page(pageRequest);
        ArticleInfoVO firstArticleInfoVO = null;
        if(pagination.getItems().size() > 0){
            firstArticleInfoVO = pagination.getItems().get(0);
        }
*//*
        model.addAttribute("pagination", pagination);
        model.addAttribute("firstArticle", firstArticleInfoVO);
        model.addAttribute("detail", false);*//*


        Map<String, Object> map = Maps.newHashMap();
        map.put("pagination", pagination);
        map.put("firstArticle", firstArticleInfoVO);
        map.put("detail", false);

        return map;
    }*/
}
