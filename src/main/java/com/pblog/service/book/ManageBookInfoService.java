package com.pblog.service.book;

import com.pblog.domain.BookInfo;
import com.pblog.web.controller.bookmanage.BookInfoFormBean;

import java.util.List;

public interface ManageBookInfoService {

    void insert(BookInfoFormBean bookInfoFormBean);

    void update(BookInfoFormBean bookInfoFormBean);

    List<BookInfo> findList();

    BookInfo findById(Integer id);
}
