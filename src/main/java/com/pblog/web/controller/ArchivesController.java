package com.pblog.web.controller;

import com.pblog.service.archives.ArchivesService;
import com.pblog.service.archives.ArchivesVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class ArchivesController {

    private final static Logger logger = LoggerFactory.getLogger(ArchivesController.class);

    @Resource(name = "archivesService")
    private ArchivesService archivesService;

    @RequestMapping(value = "/archives/layout", method = RequestMethod.GET)
    public String getArchivesPage(HttpServletRequest request, Model model){

        return "web/archives/archives";
    }

    @RequestMapping(value ="/archivesList", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public List<ArchivesVO> list(HttpServletRequest request, Model model){
        List<ArchivesVO> archivesVOList = null;

        try {
            archivesVOList = archivesService.findArchivesList();
        } catch (ParseException e) {
            logger.info(e.getMessage());
        }

        return archivesVOList;
    }

    /*@RequestMapping(value = "/archives")
    public String index(HttpServletRequest request, Model model){
        List<ArchivesVO> archivesVOList = null;
        Integer articleNum = 0;

        try {
            archivesVOList = archivesService.findArchivesList();
            for(ArchivesVO archivesVO : archivesVOList){
                articleNum += archivesVO.getArticleInfoVOList().size();
            }

            model.addAttribute("archivesVOList", archivesVOList);
            model.addAttribute("articleInfoVOList", archivesVOList.size() > 0 ? archivesVOList.get(0).getArticleInfoVOList() : null);
            model.addAttribute("num", articleNum);
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
    public String month(@PathVariable String timeStamp, HttpServletRequest request, Model model) throws ParseException {
        boolean isRightPattern =  GenerateUtils.judgeTimeStamp(timeStamp);
        List<ArchivesVO> archivesVOList = null;

        if(isRightPattern){
            List<ArticleInfoVO> articleInfoVOList = archivesService.findArticleByMonth(timeStamp);
            archivesVOList = archivesService.findArchivesList();

            model.addAttribute("archivesVOList", archivesVOList);
            model.addAttribute("articleInfoVOList", articleInfoVOList);
            model.addAttribute("timeStamp", DateFormatUtils.formatStrToYM(timeStamp));

            Boolean mobile = (Boolean) request.getAttribute("mobile");
            if(mobile){
                return "web/archives/archives_mobile_time";
            }else {
                return "web/archives/archives";
            }
        }else{
            return "404";
        }
    }*/
}
