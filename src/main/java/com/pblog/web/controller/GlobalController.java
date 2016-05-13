package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GlobalController {

    @RequestMapping("/switch")
    public String switchModel(@RequestParam(value = "mo")Integer mo, HttpServletRequest request,
                              Model model) {
        if(mo == 1) {
            request.getSession().setAttribute("mo", "night");
        } else {
            request.getSession().setAttribute("mo", "day");
        }

        return "redirect:/";
    }
}
