package com.pblog.web.controller.picmanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("manage/pic")
public class ManagePicController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {

        return "manage/pic/list";
    }

}
