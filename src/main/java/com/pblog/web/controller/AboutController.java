package com.pblog.web.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AboutController {

    @RequestMapping(value = "/about/layout", method = RequestMethod.GET)
    public String getAboutPage(HttpServletRequest request, Model model) {

        return "web/about/layout";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> about(HttpServletRequest request, Model model) {
        Map<String, Object> map = Maps.newHashMap();

        System.out.println("打印测试");
        return map;
    }
}
