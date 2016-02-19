package com.pblog.web.controller.articlemanage;

import com.pblog.domain.ArticleInfo;
import com.pblog.service.ManageArticleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "manage/article")
public class ManageArticleController {

    @Resource(name = "manageArticleInfoService")
    private ManageArticleInfoService manageArticleInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String index(@RequestParam(value = "categorySlug", required = false)Long categorySlug,  Model model){
        List<ArticleInfo> articleInfoList =  manageArticleInfoService.findListByCategorySlug(categorySlug);

        model.addAttribute("articleInfoList", articleInfoList);
        return "manage/article/article_list";
    }

    @RequestMapping(value = "/edit")
    public String add(Model model){

        return "manage/article/article_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> adda(@ModelAttribute ArticleInfoFormBean articleInfoFormBean, Model model){
        manageArticleInfoService.insert(articleInfoFormBean);
        return null;
    }


    @RequestMapping(value = "/enabled", method = RequestMethod.POST)
    public Map<String, Object> updateEnabled(){

        return null;
    }

}
