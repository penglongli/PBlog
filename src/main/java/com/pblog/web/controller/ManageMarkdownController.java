package com.pblog.web.controller;

import com.pblog.core.markdown.GenerateHtml;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ManageMarkdownController {

    @RequestMapping(value = "/preview/markdown")
    @ResponseBody
    public Map<String, Object> previewMarkdown(@RequestParam(value = "content") String content){
        Map<String, Object> map = new HashMap<String, Object>();
        String html = GenerateHtml.markdownToHTML(content);
        map.put("html", html);
        return map;

    }

}
