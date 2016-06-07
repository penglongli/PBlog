package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResumeController {

    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        Boolean mobile = (Boolean) request.getAttribute("mobile");

        if(mobile) {
            return "web/resume/resume_mobile";
        } else {
            return "web/resume/resume";
        }
    }
}
