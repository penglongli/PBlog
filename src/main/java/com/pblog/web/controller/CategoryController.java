package com.pblog.web.controller;

import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.category.CategoryInfoService;
import com.pblog.service.category.CategoryInfoVO;
import com.pblog.service.category.SimpleCategoryInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        model.addAttribute("categoryInfoVOList", categoryInfoVOList);
        return "web/category/category";
    }
}
