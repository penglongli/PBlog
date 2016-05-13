package com.pblog.web.controller.categorymanage;

import com.google.common.collect.Maps;
import com.pblog.domain.CategoryInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "manage/category")
public class ManageCategoryController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(HttpServletRequest request, Model model) {

        return "manage/category/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String insert(@ModelAttribute CategoryInfo categoryInfo, HttpServletRequest request) {

        return "redirect:list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> update(@ModelAttribute CategoryInfo categoryInfo, HttpServletRequest request) {
        Map<String, Object> map = Maps.newHashMap();

        return map;
    }
}
