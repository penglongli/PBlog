package com.pblog.web.controller;

import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.category.CategoryInfoService;
import com.pblog.service.category.CategoryInfoVO;
import com.pblog.service.category.SimpleCategoryInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CategoryController {

    @Resource(name = "categoryInfoService")
    private CategoryInfoService categoryInfoService;

    @RequestMapping(value = "/category")
    public String index(Model model){
        List<CategoryInfoVO> categoryInfoVOList = categoryInfoService.findCategoryInfoVO();
        List<ArticleInfoVO> articleInfoVOList = categoryInfoVOList.get(0).getArticleInfoVOList();

        model.addAttribute("categoryInfoVOList", categoryInfoVOList);
        model.addAttribute("articleInfoVOList", articleInfoVOList.size() > 0 ? articleInfoVOList : null);
        return "web/category/category";
    }

    @RequestMapping(value = "/category/{slug}")
    public String list(@PathVariable Long slug, Model model){
        List<CategoryInfoVO> categoryInfoVOList = categoryInfoService.findCategoryInfoVO();
        List<ArticleInfoVO> articleInfoVOList = categoryInfoService.findArticleListByCategory(slug);

        model.addAttribute("categoryInfoVOList", categoryInfoVOList);
        model.addAttribute("articleInfoVOList", articleInfoVOList);
        model.addAttribute("slug", slug);
        return "web/category/category";
    }
}
