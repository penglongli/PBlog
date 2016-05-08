package com.pblog.web.controller.bookmanage;

import com.pblog.domain.BookInfo;
import com.pblog.domain.BookTable;
import com.pblog.service.book.BookInfoService;
import com.pblog.service.book.BookInfoVO;
import com.pblog.service.book.ManageBookInfoService;
import com.pblog.service.book.ManageBookTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "manage/book")
public class ManageBookInfoController {

    @Resource(name = "manageBookInfoService")
    private ManageBookInfoService manageBookInfoService;

    @Resource(name = "manageBookTableService")
    private ManageBookTableService manageBookTableService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        List<BookInfo> bookInfoList = manageBookInfoService.findList();
        List<BookTable> bookTableList = manageBookTableService.findAll();

        model.addAttribute("bookInfoList", bookInfoList);
        model.addAttribute("bookTableList", bookTableList);
        return "manage/book/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String editPage(Model model) {

        model.addAttribute("type", 1);
        return "manage/book/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable Integer id, Model model) {
        BookInfo bookInfo = manageBookInfoService.findById(id);

        model.addAttribute("bookInfo", bookInfo);
        model.addAttribute("type", 2);
        return "manage/book/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(@ModelAttribute BookInfoFormBean bookInfoFormBean) {
        manageBookInfoService.insert(bookInfoFormBean);

        return "redirect:list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute BookInfoFormBean bookInfoFormBean) {
        manageBookInfoService.update(bookInfoFormBean);
        return "redirect:list";
    }
}
