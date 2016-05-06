package com.pblog.service.book;

import com.pblog.dao.BookInfoMapper;
import com.pblog.domain.BookInfo;
import com.pblog.web.controller.bookmanage.BookInfoFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "manageBookInfoService")
public class ManageBookInfoServiceImpl implements ManageBookInfoService{

    @Autowired
    private BookInfoMapper bookInfoMapper;

    public void insert(BookInfoFormBean bookInfoFormBean) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setTitle(bookInfoFormBean.getTitle());
        bookInfo.setBanner(bookInfoFormBean.getBanner());
        bookInfo.setIntroduction(bookInfoFormBean.getIntroduction());
        bookInfo.setContent(bookInfoFormBean.getContent());

        bookInfoMapper.insert(bookInfo);
    }

    public void update(BookInfoFormBean bookInfoFormBean) {
        BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(bookInfoFormBean.getId());

        if(null == bookInfo) {
            throw new RuntimeException("updates book filed, please check 'id' is correct !");
        }
        bookInfo.setTitle(bookInfoFormBean.getTitle());
        bookInfo.setBanner(bookInfoFormBean.getBanner());
        bookInfo.setIntroduction(bookInfoFormBean.getIntroduction());
        bookInfo.setContent(bookInfoFormBean.getContent());

        bookInfoMapper.insert(bookInfo);
    }

    public List<BookInfo> findList() {

        return bookInfoMapper.selectAll();
    }
}
