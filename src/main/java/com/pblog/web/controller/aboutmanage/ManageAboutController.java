package com.pblog.web.controller.aboutmanage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "manage/about")
public class ManageAboutController {

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        return "manage/about/about_edit";
    }

}
