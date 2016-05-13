package com.pblog.web.controller.picmanage;

import com.google.common.collect.Maps;
import com.pblog.domain.PicInfo;
import com.pblog.service.pic.PicInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manage/pic")
public class ManagePicController {

    @Resource(name = "picInfoService")
    private PicInfoService picInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        List<PicInfo> picInfoList = picInfoService.list();

        model.addAttribute("picInfoList", picInfoList);
        return "manage/pic/list";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file")MultipartFile file,
                                      HttpServletRequest request) throws IOException {
        picInfoService.upload(file);

        return "redirect:list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(@RequestParam(value = "picId") Long picId, HttpServletRequest request) {
        Map<String, Object> map = Maps.newHashMap();

        int status = picInfoService.deleteById(picId);
        map.put("status", status);
        return map;
    }


}
