package com.pblog.web.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pblog.core.utils.DateFormatUtils;
import com.pblog.domain.RecordInfo;
import com.pblog.service.record.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class RecordController {

    @Resource(name = "recordService")
    private RecordService recordService;

    //------------------PC端----------------------

    @RequestMapping(value = "/record/layout", method = RequestMethod.GET)
    public String layout() {

        return "web/record/layout";
    }

    @RequestMapping(value = "/record", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> record() {
        Map<String, Object> map = Maps.newHashMap();

        List<RecordInfo> recordInfoList = recordService.list();
        map.put("recordInfoList", recordInfoList);
        return map;
    }

    //-----------移动端--------------------
    @RequestMapping(value = "/record/detail", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        List<RecordInfo> recordInfoList = recordService.list();
        List<Boolean> nightList = Lists.newArrayList();

        for (RecordInfo recordInfo : recordInfoList) {
            Integer hour = DateFormatUtils.formatToHour(recordInfo.getCreateTime());

            //19:00 — 5:00 夜晚，6:00 — 19:00 白天
            if (hour >= 19 || hour <= 5) {
                nightList.add(true);
            } else {
                nightList.add(false);
            }
        }

        model.addAttribute("recordInfoList", recordInfoList);
        model.addAttribute("nightList", nightList);
        return "web/record/record_mobile";
    }
}
