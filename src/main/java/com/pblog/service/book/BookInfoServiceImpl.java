package com.pblog.service.book;

import com.google.common.collect.Lists;
import com.pblog.dao.BookInfoMapper;
import com.pblog.domain.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "bookInfoService")
@Transactional
public class BookInfoServiceImpl implements BookInfoService{

    @Autowired
    private BookInfoMapper bookInfoMapper;

    public List<BookInfoVO> findList() {
        List<BookInfoVO> bookInfoVOList = Lists.newArrayList();

        List<BookInfo> bookInfoList = bookInfoMapper.selectAll();
        for (BookInfo bookInfo : bookInfoList) {
            BookInfoVO bookInfoVO = transToBookInfoVO(bookInfo);
            bookInfoVOList.add(bookInfoVO);
        }

        return bookInfoVOList;
    }

    public BookInfoVO findBySlug(Long slug) {
        BookInfo bookInfo = bookInfoMapper.selectBySlug(slug);

        return transToBookInfoVO(bookInfo);
    }

    private BookInfoVO transToBookInfoVO(BookInfo bookInfo) {
        BookInfoVO bookInfoVO = new BookInfoVO();
        bookInfoVO.setSlug(bookInfo.getSlug());
        bookInfoVO.setTitle(bookInfo.getTitle());
        bookInfoVO.setBanner(bookInfo.getBanner());
        bookInfoVO.setThumb(bookInfo.getThumb());
        bookInfoVO.setIntroduction(bookInfo.getIntroduction());
        bookInfoVO.setContent(bookInfo.getContent());
        bookInfoVO.setReviewNum(1L);

        return new BookInfoVO();
    }
}
