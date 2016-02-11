package com.pblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArchivesController {

    @RequestMapping(value = "/archives")
    public String index(Model model){
        return "web/archives/archives";
    }

}
