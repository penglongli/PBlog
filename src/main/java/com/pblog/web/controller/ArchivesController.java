package com.pblog.web.controller;

import com.pblog.core.utils.DateFormatUtils;
import com.pblog.core.utils.GenerateUtils;
import com.pblog.service.archives.ArchivesService;
import com.pblog.service.archives.ArchivesVO;
import com.pblog.service.article.ArticleInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class ArchivesController {

    @Resource(name = "archivesService")
    private ArchivesService archivesService;


    @RequestMapping(value = "/archives")
    public String index(HttpServletRequest request, Model model){
        List<ArchivesVO> archivesVOList = null;
        try {
            archivesVOList = archivesService.findArchivesList();

            model.addAttribute("archivesVOList", archivesVOList);
            model.addAttribute("articleInfoVOList", archivesVOList.size() > 0 ? archivesVOList.get(0).getArticleInfoVOList() : null);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if(mobile){
            return "web/archives/archives_mobile";
        }else{
            return "web/archives/archives";
        }

    }


    @RequestMapping(value = "/archives/{timeStamp}", method = RequestMethod.GET)
    public String month(@PathVariable String timeStamp, Model model) throws ParseException {
        boolean isRightPattern =  GenerateUtils.judgeTimeStamp(timeStamp);
        List<ArchivesVO> archivesVOList = null;

        if(isRightPattern){
            List<ArticleInfoVO> articleInfoVOList = archivesService.findArticleByMonth(timeStamp);
            archivesVOList = archivesService.findArchivesList();

            model.addAttribute("archivesVOList", archivesVOList);
            model.addAttribute("articleInfoVOList", articleInfoVOList);
            model.addAttribute("timeStamp", DateFormatUtils.formatStrToYM(timeStamp));
            return "web/archives/archives";
        }else{
            return "404";
        }
    }
}
