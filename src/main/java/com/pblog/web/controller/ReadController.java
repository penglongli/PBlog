package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReadController {

    @RequestMapping(value = "/read/layout", method = RequestMethod.GET)
    public String layout(HttpServletRequest request, Model model) {

        return "";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        return "";
    }
}
