package com.pblog.web.controller.recordmanage;

import com.google.common.collect.Maps;
import com.pblog.domain.RecordInfo;
import com.pblog.service.record.ManageRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "manage/record")
public class ManageRecordController {

    @Resource(name = "manageRecordService")
    private ManageRecordService manageRecordService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        List<RecordInfo> recordInfoList = manageRecordService.list();

        model.addAttribute("recordInfoList", recordInfoList);
        return "manage/record/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(@ModelAttribute RecordInfo recordInfo, Model model) {
        manageRecordService.insert(recordInfo);

        return "redirect:list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute RecordInfo recordInfo, Model model) {
        manageRecordService.update(recordInfo);

        return "redirect:list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> recordById(@PathVariable Integer id) {
        Map<String, Object> map = Maps.newHashMap();

        RecordInfo recordInfo = manageRecordService.findById(id);
        map.put("recordInfo", recordInfo);
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(@RequestParam(value = "id") Integer id) {
        Map<String, Object> map = Maps.newHashMap();

        int status = manageRecordService.delete(id);
        map.put("status", status);

        return map;
    }

}
