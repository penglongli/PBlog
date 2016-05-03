package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AboutController {

    @RequestMapping(value = "/about/layout", method = RequestMethod.GET)
    public String getAboutPage(HttpServletRequest request, Model model) {

        return "web/about/layout";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        Boolean mobile = (Boolean) request.getAttribute("mobile");

        if(mobile) {
            return "web/about/about_mobile";
        } else {
            return "redirect:/#/about";
        }
    }
}
