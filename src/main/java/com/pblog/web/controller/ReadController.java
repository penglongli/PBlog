package com.pblog.web.controller;

import com.google.common.collect.Maps;
import com.pblog.domain.BookTable;
import com.pblog.service.book.BookInfoService;
import com.pblog.service.book.BookInfoVO;
import com.pblog.service.book.BookTableService;
import com.pblog.service.book.BookTableVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ReadController {

    @Resource(name = "bookInfoService")
    private BookInfoService bookInfoService;

    @Resource(name = "bookTableService")
    private BookTableService bookTableService;

    //--------------------PC端------------------------

    @RequestMapping(value = "/read/layout", method = RequestMethod.GET)
    public String indexLayout(HttpServletRequest request, Model model) {

        return "web/book/layout";
    }

    @RequestMapping(value = "/read/slug/layout", method = RequestMethod.GET)
    public String slugLayout(HttpServletRequest request, Model model) {

        return "web/book/detail";
    }

    @RequestMapping(value = "/book/list", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request) {
        Map<String, Object> map = Maps.newHashMap();

        List<BookInfoVO> bookInfoVOList = bookInfoService.findList();
        List<BookTableVO> bookTableVOList = bookTableService.findList();
        map.put("bookInfoVOList", bookInfoVOList);
        map.put("bookTableVOList", bookTableVOList);

        return map;
    }

    @RequestMapping(value = "/book/{slug}", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> slug(@PathVariable Long slug, HttpServletRequest request) {
        Map<String, Object> map = Maps.newHashMap();
        String ipAddress = (String) request.getAttribute("realIp");

        BookInfoVO bookInfoVO = bookInfoService.findBySlug(slug, ipAddress);
        map.put("bookInfoVO", bookInfoVO);

        return map;
    }

    //------------------手机端--------------------------

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if (!mobile) {
            return "redirect:/#/read";
        }

        List<BookInfoVO> bookInfoVOList = bookInfoService.findList();

        model.addAttribute("bookInfoVOList", bookInfoVOList);
        return "web/book/read_mobile";
    }

    @RequestMapping(value = "/read/{slug}/detail", method = RequestMethod.GET)
    public String slugDetail(@PathVariable Long slug, HttpServletRequest request, Model model) {
        String ipAddress = (String) request.getAttribute("realIp");

        BookInfoVO bookInfoVO = bookInfoService.findBySlug(slug, ipAddress);
        model.addAttribute("bookInfoVO", bookInfoVO);
        return "web/book/read_mobile_detail";
    }

}
