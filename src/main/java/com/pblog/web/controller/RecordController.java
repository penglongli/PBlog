package com.pblog.web.controller;

import com.google.common.collect.Maps;
import com.pblog.domain.RecordInfo;
import com.pblog.service.record.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class RecordController {

    @Resource(name = "recordService")
    private RecordService recordService;

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
}
