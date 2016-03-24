package com.pblog.web.controller;

import com.pblog.core.orm.PageRequest;
import com.pblog.core.orm.Pagination;
import com.pblog.service.article.ArticleInfoService;
import com.pblog.service.article.ArticleInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource(name = "articleInfoService")
    private ArticleInfoService articleInfoService;

    @RequestMapping(value = {"/", "/article/list"}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "p", required = false)Integer page, Model model){
        page = (null == page) ? 1 : page;
        PageRequest pageRequest = new PageRequest(page, 10);

        Pagination<ArticleInfoVO> pagination = articleInfoService.page(pageRequest);
        ArticleInfoVO firstArticleInfoVO = null;
        if(pagination.getItems().size() > 0){
            firstArticleInfoVO = pagination.getItems().get(0);
        }

        model.addAttribute("pagination", pagination);
        model.addAttribute("content", firstArticleInfoVO == null ? null : firstArticleInfoVO.getContent());
        return "web/index/index";
    }
}
