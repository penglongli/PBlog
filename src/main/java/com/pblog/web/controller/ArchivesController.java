package com.pblog.web.controller;

import com.pblog.service.archives.ArchivesService;
import com.pblog.service.archives.ArchivesVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@Controller
public class ArchivesController {

    @Resource(name = "archivesService")
    private ArchivesService archivesService;


    @RequestMapping(value = "/archives")
    public String index(Model model){
        List<ArchivesVO> archivesVOList = null;
        try {
            archivesVOList = archivesService.findArchivesList();
            model.addAttribute("archivesVOList", archivesVOList);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "web/archives/archives";
    }

}
