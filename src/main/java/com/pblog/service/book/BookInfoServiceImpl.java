package com.pblog.service.book;

import com.google.common.collect.Lists;
import com.pblog.dao.BookInfoMapper;
import com.pblog.dao.BookReadLogMapper;
import com.pblog.domain.BookInfo;
import com.pblog.domain.BookReadLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(value = "bookInfoService")
@Transactional
public class BookInfoServiceImpl implements BookInfoService{

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Autowired
    private BookReadLogMapper bookReadLogMapper;


    public List<BookInfoVO> findList() {
        List<BookInfoVO> bookInfoVOList = Lists.newArrayList();

        List<BookInfo> bookInfoList = bookInfoMapper.selectAll();
        for (BookInfo bookInfo : bookInfoList) {
            BookInfoVO bookInfoVO = transToBookInfoVO(bookInfo);
            bookInfoVOList.add(bookInfoVO);
        }

        return bookInfoVOList;
    }

    public BookInfoVO findBySlug(Long slug, String ipAddress) {
        BookInfo bookInfo = bookInfoMapper.selectBySlug(slug);

        BookReadLog bookReadLog = new BookReadLog();
        bookReadLog.setBookId(bookInfo.getId());
        bookReadLog.setCreateTime(new Date());
        bookReadLog.setIpAddress(ipAddress);
        bookReadLog.setType(BookReadLog.BookReadType.TYPE_READ.getId());
        bookReadLogMapper.insert(bookReadLog);

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
        bookInfoVO.setCreateTime(bookInfo.getCreateTime());

        Long reviewNum = bookReadLogMapper.selectNumById(bookInfo.getId());
        bookInfoVO.setReviewNum(reviewNum);

        return bookInfoVO;
    }
}
