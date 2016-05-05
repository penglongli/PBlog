package com.pblog.service.book;

import com.pblog.web.controller.readmanage.BookInfoFormBean;

public interface ManageBookInfoService {

    void insert(BookInfoFormBean bookInfoFormBean);

    void update(BookInfoFormBean bookInfoFormBean);
}
