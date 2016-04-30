package com.pblog.web.controller.aboutmanage;

import com.pblog.domain.AboutInfo;
import com.pblog.service.about.AboutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "manage/about")
public class ManageAboutController {

    @Resource(name = "aboutService")
    private AboutService aboutService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        AboutInfo aboutInfo = aboutService.findAboutInfo();
        aboutInfo = aboutInfo == null ? new AboutInfo() : aboutInfo;

        model.addAttribute("aboutInfo", aboutInfo);
        return "manage/about/about_edit";
    }

}
