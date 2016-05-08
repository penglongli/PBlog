package com.pblog.service.book;

import com.pblog.dao.BookInfoMapper;
import com.pblog.dao.SlugInfoMapper;
import com.pblog.domain.BookInfo;
import com.pblog.domain.SlugInfo;
import com.pblog.web.controller.bookmanage.BookInfoFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "manageBookInfoService")
public class ManageBookInfoServiceImpl implements ManageBookInfoService{

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Autowired
    private SlugInfoMapper slugInfoMapper;

    public void insert(BookInfoFormBean bookInfoFormBean) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setTitle(bookInfoFormBean.getTitle());
        bookInfo.setBanner(bookInfoFormBean.getBanner());
        bookInfo.setIntroduction(bookInfoFormBean.getIntroduction());
        bookInfo.setContent(bookInfoFormBean.getContent());
        bookInfo.setCreateTime(new Date());
        bookInfoMapper.insert(bookInfo);

        SlugInfo slugInfo = slugInfoMapper.queryById(bookInfo.getId());
        bookInfo.setSlug(slugInfo.getSlug());
        bookInfoMapper.updateByPrimaryKey(bookInfo);
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

        bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    public List<BookInfo> findList() {

        return bookInfoMapper.selectAll();
    }

    public BookInfo findById(Integer id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }
}
