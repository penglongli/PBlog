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
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {

    @Resource(name = "categoryInfoService")
    private CategoryInfoService categoryInfoService;

    @RequestMapping(value = "/category")
    public String index(HttpServletRequest request, Model model){
        List<CategoryInfoVO> categoryInfoVOList = categoryInfoService.findCategoryInfoVO();
        List<ArticleInfoVO> articleInfoVOList = categoryInfoVOList.get(0).getArticleInfoVOList();

        model.addAttribute("categoryInfoVOList", categoryInfoVOList);
        model.addAttribute("articleInfoVOList", articleInfoVOList.size() > 0 ? articleInfoVOList : null);
        model.addAttribute("num", categoryInfoVOList.size());

        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if(mobile){
            return "web/category/category_mobile";
        }else{
            return "web/category/category";
        }
    }

    @RequestMapping(value = "/category/{slug}")
    public String list(@PathVariable Long slug, HttpServletRequest request, Model model){
        List<CategoryInfoVO> categoryInfoVOList = categoryInfoService.findCategoryInfoVO();
        List<ArticleInfoVO> articleInfoVOList = categoryInfoService.findArticleListByCategory(slug);

        model.addAttribute("categoryInfoVOList", categoryInfoVOList);
        model.addAttribute("articleInfoVOList", articleInfoVOList);
        model.addAttribute("slug", slug);

        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if(mobile){
            return "web/category/category_by_slug";
        }
        return "web/category/category";
    }
}
