package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResumeController {

    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {

        return "web/resume/resume";
    }
}
