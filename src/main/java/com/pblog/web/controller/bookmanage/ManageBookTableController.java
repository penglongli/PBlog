package com.pblog.web.controller.bookmanage;

import com.google.common.collect.Maps;
import com.pblog.domain.BookTable;
import com.pblog.service.book.ManageBookTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("manage/read")
public class ManageBookTableController {

    @Resource(name = "manageBookTableService")
    private ManageBookTableService manageBookTableService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(@ModelAttribute BookTable bookTable, Model model) {
        manageBookTableService.insert(bookTable);

        return "redirect:/manage/book/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute BookTable bookTable, Model model) {
        manageBookTableService.update(bookTable);

        return "redirect:/manage/book/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(@RequestParam(name = "bookTableId", required = true)Integer bookTableId) {
        Map<String, Object> map = Maps.newHashMap();

        int status = manageBookTableService.delete(bookTableId);
        map.put("status", status);
        return map;
    }

}
