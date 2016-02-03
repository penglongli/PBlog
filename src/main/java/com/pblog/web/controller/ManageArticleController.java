package com.pblog.web.controller;

import com.pblog.core.markdown.GenerateHtml;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ManageArticleController {

    @RequestMapping("/")
    public String index(Model model){
        return "manage/article/article_list";
    }

    @RequestMapping("/add")
    public String add(Model model){

        return "manage/article/article_add";
    }


    @RequestMapping(value = "/preview/markdown")
    @ResponseBody
    public Map<String, Object> previewMarkdown(@RequestParam(value = "content") String content){
        System.out.println(content);
        System.out.println("打印结束----------------------------");
        Map<String, Object> map = new HashMap<String, Object>();
        String html = GenerateHtml.markdownToHTML(content);
        System.out.println("\n\n\n");
        System.out.println(html);
        map.put("html", html);
        return map;

    }
}
